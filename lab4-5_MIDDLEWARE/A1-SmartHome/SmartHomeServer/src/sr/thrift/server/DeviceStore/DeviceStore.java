package sr.thrift.server.DeviceStore;

import generated.rpc.*;
import generated.rpc.DeviceObject;
import generated.rpc.DeviceState;
import java.util.HashMap;
import java.util.Random;

public class DeviceStore {
    private final Random random;
    private int nextDeviceID;

    public HashMap<String, FridgeObject> fridges;
    public HashMap<String, LampObject> lamps;
    public HashMap<String, VacuumCleanerObject> vacuumCleaners;
    public HashMap<String, KettleObject> kettles;

    public DeviceStore(int numberOfDevice) {
        this.random = new Random();

        this.nextDeviceID = 0;

        this.fridges = new HashMap<>();
        this.lamps = new HashMap<>();
        this.vacuumCleaners = new HashMap<>();
        this.kettles = new HashMap<>();

        createRandomDevices(numberOfDevice);
    }

    private void createRandomDevices(int numberOfDevices) {
        for (int i = 0; i < numberOfDevices; i++) {
            nextDeviceID += 1;

            DeviceObject device = createRandomDevice();

            int typeOfDevice = random.nextInt(4);
            switch (typeOfDevice) {
                case 0:
                    FridgeObject fridgeObject = createRandomFridge();
                    device.setId(String.valueOf(nextDeviceID));
                    device.setType(DeviceType.FRIDGE);
                    fridgeObject.setDevice(device);
                    this.fridges.put(device.getId(), fridgeObject);
                    break;
                case 1:
                    LampObject lampObject = createRandomLamp();
                    device.setId(String.valueOf(nextDeviceID));
                    device.setType(DeviceType.LAMP);
                    lampObject.setDevice(device);
                    lampObject.setIntensity(100);
                    this.lamps.put(device.getId(), lampObject);
                    break;
                case 2:
                    VacuumCleanerObject vacuumCleanerObject = createRandomVacuumCleaner();
                    device.setId(String.valueOf(nextDeviceID));
                    device.setType(DeviceType.VACUUM_CLEANER);
                    vacuumCleanerObject.setDevice(device);
                    this.vacuumCleaners.put(device.getId(), vacuumCleanerObject);
                    break;
                case 3:
                    KettleObject kettleObject = createRandomKettle();
                    device.setId(String.valueOf(nextDeviceID));
                    device.setType(DeviceType.KETTLE);
                    kettleObject.setDevice(device);
                    this.kettles.put(device.getId(), kettleObject);
            }
        }
    }

    private DeviceObject createRandomDevice() {
        DeviceObject deviceObject = new DeviceObject();

        int stateOfDevice = random.nextInt(2);
        switch(stateOfDevice){
            case 0:
                deviceObject.setState(DeviceState.ON);
                break;
            case 1:
                deviceObject.setState(DeviceState.OFF);
                break;
        }

        return deviceObject;
    }

    private FridgeObject createRandomFridge() {
        FridgeObject fridgeObject = new FridgeObject();

        fridgeObject.setTemperature(random.nextInt(21) - 10);

        return fridgeObject;
    }

    private LampObject createRandomLamp() {
        LampObject ledLampObject = new LampObject();

        int color = random.nextInt(4);
        switch (color){
            case 0:
                ledLampObject.setColor(LightColor.BLUE);
                break;
            case 1:
                ledLampObject.setColor(LightColor.GREEN);
                break;
            case 2:
                ledLampObject.setColor(LightColor.RED);
                break;
            case 3:
                ledLampObject.setColor(LightColor.YELLOW);
                break;
        }

        return ledLampObject;
    }

    private VacuumCleanerObject createRandomVacuumCleaner() {
        VacuumCleanerObject vacuumCleanerObject = new VacuumCleanerObject();
        vacuumCleanerObject.setBattery(random.nextInt(100));

        switch(random.nextInt(3)){
            case 0:
                vacuumCleanerObject.setCapacity(Capacity.EMPTY);
                break;
            case 1:
                vacuumCleanerObject.setCapacity(Capacity.HALF_EMPTY);
                break;
            case 2:
                vacuumCleanerObject.setCapacity(Capacity.FULL);
                break;
        }

        return vacuumCleanerObject;
    }

    private KettleObject createRandomKettle() {
        KettleObject kettleObject = new KettleObject();
        kettleObject.setTemperature(random.nextInt(101));

        switch(random.nextInt(2)) {
            case 0:
                kettleObject.setType(KettleType.GAS);
                break;
            case 1:
                kettleObject.setType(KettleType.ELECTRIC);
                break;
        }

        return kettleObject;
    }

    public void printAllDevices() {
        System.out.println("FRIDGES");
        fridges.forEach((key, fridge) -> System.out.println(fridge));

        System.out.println("LAMPS");
        lamps.forEach((key, lamp) -> System.out.println(lamp));

        System.out.println("VACUUM CLEANERS");
        vacuumCleaners.forEach((key, vacuumCleaner) -> System.out.println(vacuumCleaner));

        System.out.println("KETTLES");
        kettles.forEach((key, kettle) -> System.out.println(kettle));
    }

    public FridgeObject getFridgeById(String id) {
        if (fridges.containsKey(id)) {
            return fridges.get(id);
        }
        return null;
    }

    public LampObject getLampById(String id) {
        if (lamps.containsKey(id)) {
            return lamps.get(id);
        }

        return null;
    }

    public VacuumCleanerObject getVacuumCleanerById(String id) {
        if (vacuumCleaners.containsKey(id)) {
            return vacuumCleaners.get(id);
        }

        return null;
    }

    public KettleObject getKettleById(String id) {
        if (kettles.containsKey(id)) {
            return kettles.get(id);
        }

        return null;
    }

    public HashMap<String, FridgeObject> getFridges() {
        return fridges;
    }

    public HashMap<String, LampObject> getLamps() {
        return lamps;
    }

    public HashMap<String, VacuumCleanerObject> getVacuumCleaners() {
        return vacuumCleaners;
    }

    public HashMap<String, KettleObject> getKettles() {
        return kettles;
    }
}
