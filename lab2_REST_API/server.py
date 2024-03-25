import os

from fastapi import FastAPI, Request, HTTPException, status, Form, Response, Depends
from fastapi.exceptions import RequestValidationError
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from starlette.exceptions import HTTPException as StarletteHTTPException
import httpx
from starlette.responses import RedirectResponse

from models.User import User
from security import AuthHandler, RequiresLoginException

WEATHERAPI_KEY = os.environ['WEATHERAPI_KEY']
WEATHERAPI_HOST = "api.weatherbit.io"

GEOLOCATION_KEY = os.environ['GEOLOCATION_KEY']
GEOLOCATION_HOST = "https://api.api-ninjas.com"

PERMITTED_KEYS = ["1234"]

app = FastAPI()

templates = Jinja2Templates(directory="templates")

auth_handler = AuthHandler()


@app.exception_handler(RequiresLoginException)
async def exception_handler(request: Request, exc: RequiresLoginException) -> Response:
    """ this handler allows me to route the login exception to the login page."""
    return RedirectResponse(url='/')


@app.exception_handler(RequestValidationError)
async def validation_exception_handler(request: Request, exc: RequestValidationError):
    messages = [f"{error['loc'][1]} - {error['msg']}" for error in exc.errors()]

    return templates.TemplateResponse("error.html", {
        "request": request,
        "status_code": status.HTTP_422_UNPROCESSABLE_ENTITY,
        "detail": ", ".join(messages)
    })


@app.exception_handler(StarletteHTTPException)
async def http_exception_handler(request: Request, exc: StarletteHTTPException):
    return templates.TemplateResponse("error.html", {
        "request": request,
        "status_code": exc.status_code,
        "detail": exc.detail
    })


@app.middleware("http")
async def create_auth_header(request: Request, call_next):
    if ("Authorization" not in request.headers
            and "Authorization" in request.cookies
    ):
        access_token = request.cookies["Authorization"]

        request.headers.__dict__["_list"].append(
            (
                "authorization".encode(),
                f"Bearer {access_token}".encode(),
            )
        )
    elif ("Authorization" not in request.headers
          and "Authorization" not in request.cookies
    ):
        request.headers.__dict__["_list"].append(
            (
                "authorization".encode(),
                f"Bearer 12345".encode(),
            )
        )

    response = await call_next(request)
    return response


@app.get("/", response_class=HTMLResponse)
async def root(request: Request):
    return templates.TemplateResponse("index.html", {"request": request})


@app.get("/register", response_class=HTMLResponse)
async def register(request: Request):
    return templates.TemplateResponse("register.html", {"request": request})


@app.post("/register", response_class=HTMLResponse)
async def register(request: Request, email: str = Form(...), password: str = Form(...)):
    user = User(email=email, password=password)
    with open("users.txt", "a") as file:
        file.write(f"{user.email},{auth_handler.get_hash_password(user.password)}\n")
    response = templates.TemplateResponse("index.html",
                                          {"request": request, "success_msg": "Successfully Registration!",
                                           "path route": "/", "path_msg": "Click here to login!"})
    return response


@app.post("/login")
async def login(request: Request, response: Response,
                email: str = Form(...), password: str = Form()):
    try:
        user = User(email=email, password=password)
        if await auth_handler.authenticate_user(user.email, user.password):
            atoken = auth_handler.create_access_token(user.email)
            response = templates.TemplateResponse("form.html",
                                                  {"request": request, "USERNAME": user.email,
                                                   "success_msg": "Welcome back! "
                                                   })

            response.set_cookie(key="Authorization", value=f"{atoken}", httponly=True)
            return response
        else:
            return templates.TemplateResponse("error.html",
                                              {"request": request, "detail": "Invalid Credentials",
                                               "status_code": 404})
    except Exception as e:
        return templates.TemplateResponse("error.html",
                                          {"request": request, "detail": "Invalid Credentials",
                                           "status_code": 401})


@app.get("/form", response_class=HTMLResponse)
async def form(request: Request, email: str = Depends(auth_handler.auth_wrapper)):
    try:
        return templates.TemplateResponse("form.html", {"request": request})
    except Exception as e:
        RequiresLoginException()


@app.get("/weather", response_class=HTMLResponse)
async def weather(request: Request, city: str, date_from: str, date_to: str,
                  key: str | None, email: str = Depends(auth_handler.auth_wrapper)):
    if key is None:
        raise HTTPException(status_code=401, detail="Validation key is not present")
    if key not in PERMITTED_KEYS:
        raise HTTPException(status_code=403,
                            detail="Validation key does not have required permission to access requested content")
    if city == "":
        raise HTTPException(status_code=400, detail="City cannot be empty")
    if date_from == "" or date_to == "":
        raise HTTPException(status_code=400, detail="Start date and end date are required")
    if date_from > date_to:
        raise HTTPException(status_code=400, detail="Start date must be before end date")

    latitude, longitude = get_city(city)
    weathers = await get_weathers(latitude, longitude, date_from, date_to)
    air_pollution = await get_air_pollution(latitude, longitude, date_from, date_to)

    app_temp_values = [w["app_temp"] for w in weathers]
    airq_temp_values = [a["aqi"] for a in air_pollution]

    # Calculate average, minimum, and maximum app_temp
    average_app_temp = round(sum(app_temp_values) / len(app_temp_values), 2)
    min_app_temp = min(app_temp_values)
    max_app_temp = max(app_temp_values)

    # Calculate average, minimum and maximum air quality index
    average_airq = round(sum(airq_temp_values) / len(airq_temp_values), 2)
    min_airq = min(airq_temp_values)
    max_airq = max(airq_temp_values)

    forecast = {
        "max_temp": max_app_temp,
        "min_temp": min_app_temp,
        "avg_temp": average_app_temp,
        "max_aqi": max_airq,
        "min_aqi": min_airq,
        "avg_aqi": average_airq,
        "city": city,
        "date_from": date_from,
        "date_to": date_to
    }

    return templates.TemplateResponse("results.html", {
        "request": request,
        "forecast": forecast,
    })


def get_city(city_name: str):
    url = f'{GEOLOCATION_HOST}/v1/city?name={city_name}'
    headers = {
        "X-API-Key": GEOLOCATION_KEY,
    }
    try:
        response = httpx.get(url, headers=headers).json()
    except (httpx.HTTPError, KeyError):
        raise HTTPException(status_code=502, detail="Unable to request city informations")

    if not response:
        raise HTTPException(status_code=404, detail="City not found")

    location = [response[0]["latitude"], response[0]["longitude"]]
    latitude, longitude = location

    return latitude, longitude


async def get_weathers(latitude, longitude, date_from, date_to):
    url = f"https://{WEATHERAPI_HOST}/v2.0/history/subhourly?lat={latitude}&lon={longitude}&start_date={date_from}&end_date={date_to}&key={WEATHERAPI_KEY}"

    async with httpx.AsyncClient() as client:
        try:
            response = await client.get(url)
            json_data = response.json()["data"]
        except (httpx.HTTPError, KeyError):
            raise HTTPException(status_code=502, detail="Unable to request weather information")

    return json_data


async def get_air_pollution(latitude, longitude, date_from, date_to):
    url = f"https://{WEATHERAPI_HOST}/v2.0/history/airquality?lat={latitude}&lon={longitude}&start_date={date_from}&end_date={date_to}&tz=local&key={WEATHERAPI_KEY}"

    async with httpx.AsyncClient() as client:
        try:
            response = await client.get(url)
            json_data = response.json()["data"]
        except (httpx.HTTPError, KeyError) as e:
            raise HTTPException(status_code=502, detail="Unable to request air pollution information")

    return json_data