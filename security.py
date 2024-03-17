from typing import Union, Any

from fastapi.security import HTTPAuthorizationCredentials, HTTPBearer
from fastapi import Security
from passlib.context import CryptContext
from datetime import datetime, timedelta
from jose import jwt


class AuthHandler:
    security = HTTPBearer()
    pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")
    ALGORITHM = 'HS256'
    SECRET_KEY = '0auFzYdG8EOOx0a4YEL9a19J0eW-I9z-7eWCaAJ-mO1cZkIDFaQQtHbPX0uXPqgEp_JajdKMZg8zFs05nxNEOg'
    ACCESS_TOKEN_EXPIRE_MINUTES = 15

    def decode_token(self, token):
        try:
            payload = jwt.decode(token, self.SECRET_KEY, algorithms=[self.ALGORITHM])
            return payload['sub']
        except jwt.ExpiredSignatureError:
            raise RequiresLoginException()
        except jwt.JWTError:
            raise RequiresLoginException()
        except Exception:
            raise RequiresLoginException()

    def auth_wrapper(self, auth: HTTPAuthorizationCredentials = Security(security)):
        return self.decode_token(auth.credentials)

    def create_access_token(self, subject: Union[str, Any], expires_delta: timedelta = None) -> str:
        expire = datetime.utcnow() + (expires_delta or timedelta(minutes=self.ACCESS_TOKEN_EXPIRE_MINUTES))
        to_encode = {"exp": expire, "sub": str(subject)}
        encoded_jwt = jwt.encode(to_encode, self.SECRET_KEY, algorithm=self.ALGORITHM)
        return encoded_jwt

    def get_hash_password(self, plain_password):
        return self.pwd_context.hash(plain_password)

    def verify_password(self, plain_password, hash_password):
        return self.pwd_context.verify(plain_password, hash_password)

    async def authenticate_user(self, username, password):
        try:
            with open("users.txt", "r") as file:
                for line in file:
                    email, hashed_password = line.strip().split(",")
                    if email == username:
                        return self.verify_password(password, hashed_password)
            return False
        except Exception:
            raise RequiresLoginException()


class RequiresLoginException(Exception):
    pass
