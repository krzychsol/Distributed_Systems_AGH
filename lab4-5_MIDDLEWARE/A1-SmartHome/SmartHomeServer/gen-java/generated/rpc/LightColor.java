/**
 * Autogenerated by Thrift Compiler (0.20.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package generated.rpc;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.20.0)", date = "2024-05-06")
public enum LightColor implements org.apache.thrift.TEnum {
  BLUE(0),
  GREEN(1),
  YELLOW(2),
  RED(3);

  private final int value;

  private LightColor(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static LightColor findByValue(int value) { 
    switch (value) {
      case 0:
        return BLUE;
      case 1:
        return GREEN;
      case 2:
        return YELLOW;
      case 3:
        return RED;
      default:
        return null;
    }
  }
}
