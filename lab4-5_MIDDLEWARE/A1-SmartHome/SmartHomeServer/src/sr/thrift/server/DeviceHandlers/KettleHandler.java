package sr.thrift.server.DeviceHandlers;

import generated.rpc.*;
import org.apache.thrift.TException;
import sr.thrift.server.DeviceStore.DeviceStore;

public class KettleHandler extends DeviceHandler implements Kettle.Iface {
    public KettleHandler(DeviceStore container) {
        super(container);
    }

    @Override
    public ResultStatus getTemperature(String id) throws TException {
        System.out.println("Called GET WATER TEMPERATURE id: " + id);

        KettleObject kettleObject = deviceStore.getKettleById(id);
        if (kettleObject != null) {
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setMessage("Kettle " + "| id: " + id + " | Water Temperature: " + kettleObject.getTemperature());
            return resultStatus;
        } else {
            throw new CustomException("Get Water Temperature", "Kettle id: " + id + " has not been found.");
        }
    }

    @Override
    public ResultStatus setTemperature(String id, int value) throws TException {
        System.out.println("Called SET WATER TEMPERATURE id: " + id + " value: " + value);

        KettleObject kettleObject = deviceStore.getKettleById(id);
        if (kettleObject != null) {
            if (kettleObject.getDevice().getState() == DeviceState.OFF) {
                throw new CustomException("Set Water Temperature", "Kettle id: " + id + " is turned off. Temperature cannot be set!");
            } else if (kettleObject.getType().equals(KettleType.GAS)) {
                throw new CustomException("Set Water Temperature", "Kettle id: " + id + " is not electric. Temperature cannot be set!");
            } else {
                if (value >= 0 && value <= 100) {
                    ResultStatus resultStatus = new ResultStatus();
                    resultStatus.setMessage("Water Temperature set to " + value);
                    kettleObject.setTemperature(value);
                    System.out.println("Kettle " + id + " water temperature set to " + value);
                    return resultStatus;
                } else {
                    throw new CustomException("Set Water Temperature", "Kettle id: " + id + ". Temperature is out of range. You can set a value only in range 0 to 100!");
                }
            }
        } else {
            throw new CustomException("Set Water Temperature", "Kettle id: " + " has not been found.");
        }
    }
}
