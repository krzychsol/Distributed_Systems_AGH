package sr.thrift.client;

import genjava.CarOptional;
import genjava.CarNoOptional;
import genjava.CarshowroomService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

	public static void main(String[] args) {

		try {
			TTransport transport = new TSocket("127.0.0.2", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			CarshowroomService.Client client = new CarshowroomService.Client(protocol);

			CarNoOptional carNoOptional = new CarNoOptional();
			carNoOptional.setBrand("Tesla");
			carNoOptional.setModel("X");
			carNoOptional.setYear(2024);

			boolean res1 = client.addCarStructNoOptional(carNoOptional);
			System.out.println(res1);

			CarOptional carOptional = new CarOptional();
			carOptional.setBrand("Tesla");
			carOptional.setModel("X");

			boolean res2 = client.addCarStructOptional(carOptional);
			System.out.println(res2);

			CarOptional carOptionalSet = new CarOptional();
			carOptionalSet.setBrand("Tesla");
			carOptionalSet.setModel("X");
			carOptionalSet.setYear(2024);

			boolean res3 = client.addCarStructOptional(carOptionalSet);
			System.out.println(res3);

			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}