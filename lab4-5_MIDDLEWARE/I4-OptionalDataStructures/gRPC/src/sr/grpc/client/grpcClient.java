package sr.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import sr.proto.CarshowroomServiceGrpc;
import sr.proto.CarshowroomServiceGrpc.CarshowroomServiceBlockingStub;
import sr.proto.CarshowroomServiceProtos;

public class grpcClient {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.2", 9090)
				.usePlaintext()
				.build();

		CarshowroomServiceBlockingStub stub = CarshowroomServiceGrpc.newBlockingStub(channel);

		CarshowroomServiceProtos.AddCarNoOptionalRequest requestNoOptional = CarshowroomServiceProtos.AddCarNoOptionalRequest.newBuilder()
				.setBrand("Tesla")
				.setModel("X")
				.setYear(2024)
				.build();
		CarshowroomServiceProtos.AddCarResponse responseOptional = stub.addCarNoOptional(requestNoOptional);
		System.out.println("Response received: " + responseOptional.getResponse());

		CarshowroomServiceProtos.AddCarOptionalRequest requestOptionalNotSet = CarshowroomServiceProtos.AddCarOptionalRequest.newBuilder()
				.setBrand("Tesla")
				.setModel("X")
				.build();

		CarshowroomServiceProtos.AddCarResponse responseOptionalNotSet = stub.addCarOptional(requestOptionalNotSet);
		System.out.println("Response received: " + responseOptionalNotSet.getResponse());

		CarshowroomServiceProtos.AddCarOptionalRequest requestOptionalSet = CarshowroomServiceProtos.AddCarOptionalRequest.newBuilder()
				.setBrand("Tesla")
				.setModel("X")
				.setYear(2024)
				.build();

		CarshowroomServiceProtos.AddCarResponse responseOptionalSet = stub.addCarOptional(requestOptionalSet);
		System.out.println("Response received: " + responseOptionalSet.getResponse());

		channel.shutdown();
	}
}