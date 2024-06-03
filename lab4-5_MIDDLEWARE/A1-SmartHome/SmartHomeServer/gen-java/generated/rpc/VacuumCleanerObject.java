/**
 * Autogenerated by Thrift Compiler (0.20.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package generated.rpc;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.20.0)", date = "2024-05-06")
public class VacuumCleanerObject implements org.apache.thrift.TBase<VacuumCleanerObject, VacuumCleanerObject._Fields>, java.io.Serializable, Cloneable, Comparable<VacuumCleanerObject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("VacuumCleanerObject");

  private static final org.apache.thrift.protocol.TField DEVICE_FIELD_DESC = new org.apache.thrift.protocol.TField("device", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CAPACITY_FIELD_DESC = new org.apache.thrift.protocol.TField("capacity", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField BATTERY_FIELD_DESC = new org.apache.thrift.protocol.TField("battery", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new VacuumCleanerObjectStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new VacuumCleanerObjectTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable DeviceObject device; // required
  /**
   * 
   * @see Capacity
   */
  public @org.apache.thrift.annotation.Nullable Capacity capacity; // required
  public int battery; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEVICE((short)1, "device"),
    /**
     * 
     * @see Capacity
     */
    CAPACITY((short)2, "capacity"),
    BATTERY((short)3, "battery");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEVICE
          return DEVICE;
        case 2: // CAPACITY
          return CAPACITY;
        case 3: // BATTERY
          return BATTERY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BATTERY_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEVICE, new org.apache.thrift.meta_data.FieldMetaData("device", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DeviceObject.class)));
    tmpMap.put(_Fields.CAPACITY, new org.apache.thrift.meta_data.FieldMetaData("capacity", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Capacity.class)));
    tmpMap.put(_Fields.BATTERY, new org.apache.thrift.meta_data.FieldMetaData("battery", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(VacuumCleanerObject.class, metaDataMap);
  }

  public VacuumCleanerObject() {
  }

  public VacuumCleanerObject(
    DeviceObject device,
    Capacity capacity,
    int battery)
  {
    this();
    this.device = device;
    this.capacity = capacity;
    this.battery = battery;
    setBatteryIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public VacuumCleanerObject(VacuumCleanerObject other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDevice()) {
      this.device = new DeviceObject(other.device);
    }
    if (other.isSetCapacity()) {
      this.capacity = other.capacity;
    }
    this.battery = other.battery;
  }

  @Override
  public VacuumCleanerObject deepCopy() {
    return new VacuumCleanerObject(this);
  }

  @Override
  public void clear() {
    this.device = null;
    this.capacity = null;
    setBatteryIsSet(false);
    this.battery = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public DeviceObject getDevice() {
    return this.device;
  }

  public VacuumCleanerObject setDevice(@org.apache.thrift.annotation.Nullable DeviceObject device) {
    this.device = device;
    return this;
  }

  public void unsetDevice() {
    this.device = null;
  }

  /** Returns true if field device is set (has been assigned a value) and false otherwise */
  public boolean isSetDevice() {
    return this.device != null;
  }

  public void setDeviceIsSet(boolean value) {
    if (!value) {
      this.device = null;
    }
  }

  /**
   * 
   * @see Capacity
   */
  @org.apache.thrift.annotation.Nullable
  public Capacity getCapacity() {
    return this.capacity;
  }

  /**
   * 
   * @see Capacity
   */
  public VacuumCleanerObject setCapacity(@org.apache.thrift.annotation.Nullable Capacity capacity) {
    this.capacity = capacity;
    return this;
  }

  public void unsetCapacity() {
    this.capacity = null;
  }

  /** Returns true if field capacity is set (has been assigned a value) and false otherwise */
  public boolean isSetCapacity() {
    return this.capacity != null;
  }

  public void setCapacityIsSet(boolean value) {
    if (!value) {
      this.capacity = null;
    }
  }

  public int getBattery() {
    return this.battery;
  }

  public VacuumCleanerObject setBattery(int battery) {
    this.battery = battery;
    setBatteryIsSet(true);
    return this;
  }

  public void unsetBattery() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BATTERY_ISSET_ID);
  }

  /** Returns true if field battery is set (has been assigned a value) and false otherwise */
  public boolean isSetBattery() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BATTERY_ISSET_ID);
  }

  public void setBatteryIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BATTERY_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DEVICE:
      if (value == null) {
        unsetDevice();
      } else {
        setDevice((DeviceObject)value);
      }
      break;

    case CAPACITY:
      if (value == null) {
        unsetCapacity();
      } else {
        setCapacity((Capacity)value);
      }
      break;

    case BATTERY:
      if (value == null) {
        unsetBattery();
      } else {
        setBattery((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DEVICE:
      return getDevice();

    case CAPACITY:
      return getCapacity();

    case BATTERY:
      return getBattery();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case DEVICE:
      return isSetDevice();
    case CAPACITY:
      return isSetCapacity();
    case BATTERY:
      return isSetBattery();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof VacuumCleanerObject)
      return this.equals((VacuumCleanerObject)that);
    return false;
  }

  public boolean equals(VacuumCleanerObject that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_device = true && this.isSetDevice();
    boolean that_present_device = true && that.isSetDevice();
    if (this_present_device || that_present_device) {
      if (!(this_present_device && that_present_device))
        return false;
      if (!this.device.equals(that.device))
        return false;
    }

    boolean this_present_capacity = true && this.isSetCapacity();
    boolean that_present_capacity = true && that.isSetCapacity();
    if (this_present_capacity || that_present_capacity) {
      if (!(this_present_capacity && that_present_capacity))
        return false;
      if (!this.capacity.equals(that.capacity))
        return false;
    }

    boolean this_present_battery = true;
    boolean that_present_battery = true;
    if (this_present_battery || that_present_battery) {
      if (!(this_present_battery && that_present_battery))
        return false;
      if (this.battery != that.battery)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDevice()) ? 131071 : 524287);
    if (isSetDevice())
      hashCode = hashCode * 8191 + device.hashCode();

    hashCode = hashCode * 8191 + ((isSetCapacity()) ? 131071 : 524287);
    if (isSetCapacity())
      hashCode = hashCode * 8191 + capacity.getValue();

    hashCode = hashCode * 8191 + battery;

    return hashCode;
  }

  @Override
  public int compareTo(VacuumCleanerObject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDevice(), other.isSetDevice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDevice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.device, other.device);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCapacity(), other.isSetCapacity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCapacity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.capacity, other.capacity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBattery(), other.isSetBattery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBattery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.battery, other.battery);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("VacuumCleanerObject(");
    boolean first = true;

    sb.append("device:");
    if (this.device == null) {
      sb.append("null");
    } else {
      sb.append(this.device);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("capacity:");
    if (this.capacity == null) {
      sb.append("null");
    } else {
      sb.append(this.capacity);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("battery:");
    sb.append(this.battery);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (device != null) {
      device.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class VacuumCleanerObjectStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public VacuumCleanerObjectStandardScheme getScheme() {
      return new VacuumCleanerObjectStandardScheme();
    }
  }

  private static class VacuumCleanerObjectStandardScheme extends org.apache.thrift.scheme.StandardScheme<VacuumCleanerObject> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, VacuumCleanerObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEVICE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.device = new DeviceObject();
              struct.device.read(iprot);
              struct.setDeviceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CAPACITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.capacity = generated.rpc.Capacity.findByValue(iprot.readI32());
              struct.setCapacityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BATTERY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.battery = iprot.readI32();
              struct.setBatteryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, VacuumCleanerObject struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.device != null) {
        oprot.writeFieldBegin(DEVICE_FIELD_DESC);
        struct.device.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.capacity != null) {
        oprot.writeFieldBegin(CAPACITY_FIELD_DESC);
        oprot.writeI32(struct.capacity.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BATTERY_FIELD_DESC);
      oprot.writeI32(struct.battery);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class VacuumCleanerObjectTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public VacuumCleanerObjectTupleScheme getScheme() {
      return new VacuumCleanerObjectTupleScheme();
    }
  }

  private static class VacuumCleanerObjectTupleScheme extends org.apache.thrift.scheme.TupleScheme<VacuumCleanerObject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, VacuumCleanerObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDevice()) {
        optionals.set(0);
      }
      if (struct.isSetCapacity()) {
        optionals.set(1);
      }
      if (struct.isSetBattery()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDevice()) {
        struct.device.write(oprot);
      }
      if (struct.isSetCapacity()) {
        oprot.writeI32(struct.capacity.getValue());
      }
      if (struct.isSetBattery()) {
        oprot.writeI32(struct.battery);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, VacuumCleanerObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.device = new DeviceObject();
        struct.device.read(iprot);
        struct.setDeviceIsSet(true);
      }
      if (incoming.get(1)) {
        struct.capacity = generated.rpc.Capacity.findByValue(iprot.readI32());
        struct.setCapacityIsSet(true);
      }
      if (incoming.get(2)) {
        struct.battery = iprot.readI32();
        struct.setBatteryIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
