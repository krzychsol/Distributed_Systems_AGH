import sys

sys.path.append('./gen-py')

from genpython import CarshowroomService
from genpython.ttypes import CarOptional
from genpython.ttypes import CarNoOptional

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer


class CarshowroomServiceHandler:
    def addCarOptional(self, brand, model, year):
        print("called addCarOptional")
        print(brand)
        print(model)
        print(year)

        return True

    def addCarNoOptional(self, brand, model, year):
        print("called addCarNoOptional")
        print(brand)
        print(model)
        print(year)

        return True

    def addCarStructOptional(self, car):
        print("called addCarStructOptional")
        print(car)

        return True

    def addCarStructNoOptional(self, car):
        print("called addCarStructNoOptional")
        print(car)

        return True

handler = CarshowroomServiceHandler()
processor = CarshowroomService.Processor(handler)
transport = TSocket.TServerSocket("127.0.0.2", 9090)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print("Starting thrift server in Python...")
server.serve()
