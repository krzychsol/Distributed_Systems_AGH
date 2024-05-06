package sr.thrift.server;

import generated.rpc.*;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import sr.thrift.server.DeviceHandlers.*;
import sr.thrift.server.DeviceStore.DeviceStore;

public class ThriftHomeServer1 {
	public static void main(String[] args) {
		try {
			DeviceStore deviceStore = new DeviceStore(10);
			deviceStore.printAllDevices();

			Device.Processor<DeviceHandler> deviceProcessor = new Device.Processor<>(new DeviceHandler(deviceStore));
			Fridge.Processor<FridgeHandler> fridgeProcessor = new Fridge.Processor<>(new FridgeHandler(deviceStore));
			Lamp.Processor<LampHandler> lampHandlerProcessor = new Lamp.Processor<>(new LampHandler(deviceStore));
			VacuumCleaner.Processor<VacuumCleanerHandler> vacuumCleanerHandlerProcessor = new VacuumCleaner.Processor<>(new VacuumCleanerHandler(deviceStore));
			Kettle.Processor<KettleHandler> kettleHandlerProcessor = new Kettle.Processor<>(new KettleHandler(deviceStore));

			TServerTransport serverTrans= new TServerSocket(9010);
			TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

			TMultiplexedProcessor multiplexedProcessor=new TMultiplexedProcessor();
			multiplexedProcessor.registerProcessor("Device", deviceProcessor);
			multiplexedProcessor.registerProcessor("Fridge", fridgeProcessor);
			multiplexedProcessor.registerProcessor("Lamp", lampHandlerProcessor);
			multiplexedProcessor.registerProcessor("VacuumCleaner", vacuumCleanerHandlerProcessor);
			multiplexedProcessor.registerProcessor("Kettle", kettleHandlerProcessor);

			TServer server = new TSimpleServer(new TSimpleServer.Args(serverTrans)
					.protocolFactory(protocolFactory)
					.processor(multiplexedProcessor));

			System.out.println("[HomeServer1] Listening on localhost:9010...");

			server.serve();
		} catch(TTransportException ex) {
			throw new RuntimeException("[HomeServer1] Failed to start server: " + ex.getMessage());
		}
	}
}