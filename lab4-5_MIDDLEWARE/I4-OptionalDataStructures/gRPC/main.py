from concurrent import futures
import grpc
import carshowroom_pb2
import carshowroom_pb2_grpc


class CarshowroomServicer(carshowroom_pb2_grpc.CarshowroomServiceServicer):
    def AddCarOptional(self, request, context):
        print("called AddCarOptional")
        print(request)
        response = carshowroom_pb2.AddCarResponse(response=True)
        return response

    def AddCarNoOptional(self, request, context):
        print("called AddCarNoOptional")
        print(request)
        response = carshowroom_pb2.AddCarResponse(response=True)
        return response


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    carshowroom_pb2_grpc.add_CarshowroomServiceServicer_to_server(CarshowroomServicer(), server)
    server.add_insecure_port('127.0.0.2:9090')
    server.start()
    print("Listening on 127.0.0.2:9090...")
    server.wait_for_termination()


if __name__ == '__main__':
    serve()
