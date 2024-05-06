namespace java generated.rpc

exception CustomException {
  1: string operation
  2: string message
}

struct ResultStatus {
    1: string message
}

enum DeviceType {
    FRIDGE, LAMP, VACUUM_CLEANER, KETTLE
}

enum DeviceState {
   ON, OFF
}

service Device {
    ResultStatus getState(1: string id) throws (1: CustomException exp)
    ResultStatus turnOn(1: string id) throws (1: CustomException exp)
    ResultStatus turnOff(1: string id) throws (1: CustomException exp)
    list<string> listAllDevices()
}

struct DeviceObject {
    1: string id,
    2: DeviceType type,
    3: DeviceState state
}

struct FridgeObject {
    1: DeviceObject device
    2: i32 temperature
}

service Fridge extends Device {
    ResultStatus getTemperature(1: string id ) throws (1: CustomException exp)
    ResultStatus setTemperature(1: string id,2: i32 value) throws (1: CustomException exp)
}

enum LightColor {
    BLUE, GREEN, YELLOW, RED
}

struct LampObject {
    1: DeviceObject device
    2: LightColor color
    3: i32 intensity
}

service Lamp extends Device {
    ResultStatus getColor(1:string id) throws (1: CustomException exp)
    ResultStatus setColor(1:string id,2: LightColor color) throws (1: CustomException exp)
    ResultStatus getIntensity(1:string id) throws (1: CustomException exp)
    ResultStatus setIntensity(1:string id,2: i32 value)  throws (1: CustomException exp)
}

enum Capacity {
    EMPTY, HALF_EMPTY, FULL
}

struct VacuumCleanerObject {
    1: DeviceObject device
    2: Capacity capacity
    3: i32 battery
}

service VacuumCleaner extends Device {
     ResultStatus getBattery(1:string id) throws (1: CustomException exp)
     ResultStatus chargeUp(1:string id) throws (1: CustomException exp)
     ResultStatus getCapacity(1:string id) throws (1: CustomException exp)
     ResultStatus empty(1:string id) throws (1: CustomException exp)
}

enum KettleType {
    GAS, ELECTRIC
}

struct KettleObject {
    1: DeviceObject device
    2: KettleType type
    3: i32 temperature
}

service Kettle extends Device {
    ResultStatus getTemperature(1:string id) throws (1: CustomException exp)
    ResultStatus setTemperature(1:string id,2: i32 value) throws (1: CustomException exp)
}