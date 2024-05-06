package sr.ice.client;

import com.zeroc.Ice.*;
import Carshowroom.*;

import java.lang.Exception;

public class IceClient
{
    public static void main(String[] args)
    {
        try {
            Communicator communicator = Util.initialize();

            ObjectPrx base = communicator.stringToProxy("carshowroom:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

            CarshowroomServicePrx service = CarshowroomServicePrx.checkedCast(base);

            if(service == null)
            {
                throw new RuntimeException("Invalid proxy");
            }

            // Just arguments
            boolean res1 = service.addCarNoOptional("Tesla", "X", 2024);
            System.out.println(res1);

            boolean res2 = service.addCarOptional("Tesla", "X", java.util.OptionalInt.empty());
            System.out.println(res2);

            boolean res3 = service.addCarOptional("Tesla", "X", 2024);
            System.out.println(res3);

            // Structs
            boolean res4 = service.addCarStructNoOptional(new CarNoOptional ("Tesla", "X", 2024));
            System.out.println(res4);

            boolean res5 = service.addCarStructOptional(new CarOptional("Tesla", "X"));
            System.out.println(res5);

            boolean res6 = service.addCarStructOptional(new CarOptional("Tesla", "X", 2024));
            System.out.println(res6);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}