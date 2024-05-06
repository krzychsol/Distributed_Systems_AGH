import sys, Ice

Ice.loadSlice('slice/carshowroom.ice')
import Carshowroom


class CarshowroomServiceI(Carshowroom.CarshowroomService):
    def addCarOptional(self, brand, model, year, current=None):
        print("called addCarOptional")
        if year:
            print(brand + model + str(year))
        else:
            print(brand + model)

        return True

    def addCarNoOptional(self, brand, model, year, current=None):
        print("called addCarNoOptional")
        print(brand + model + str(year))

        return True

    def addCarStructOptional(self, car, current=None):
        print("called addCarStructOptional")
        print(car)

        return True

    def addCarStructNoOptional(self, car, current=None):
        print("called addCarStructNoOptional")
        print(car)

        return True


with Ice.initialize(sys.argv) as communicator:
    adapter = communicator.createObjectAdapterWithEndpoints("Adapter",
                                                            "tcp -h 127.0.0.2 -p 10000 -z : udp -h localhost -p 10000 -z")

    servant = CarshowroomServiceI()

    adapter.add(servant, communicator.stringToIdentity("carshowroom"))

    adapter.activate()

    print("listening on port 10000...")

    communicator.waitForShutdown()
