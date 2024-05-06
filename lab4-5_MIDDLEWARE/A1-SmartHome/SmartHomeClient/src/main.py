import sys
import time
import os

from thrift.transport import TTransport
from thrift.transport import TSocket
from thrift.protocol import TBinaryProtocol
from thrift.protocol.TMultiplexedProtocol import TMultiplexedProtocol
from thrift.transport.TTransport import TTransportException

sys.path.append('./../gen-py')

from smarthome import Fridge, Device, Lamp, VacuumCleaner, Kettle
from smarthome.ttypes import CustomException


def connect_to_home_server(home_name: str, address: str, port: int) -> None:
    trans = TSocket.TSocket(address, port)
    trans = TTransport.TBufferedTransport(trans)
    protocol = TBinaryProtocol.TBinaryProtocol(trans)

    device = Device.Client(TMultiplexedProtocol(protocol, "Device"))
    fridge = Fridge.Client(TMultiplexedProtocol(protocol, "Fridge"))
    lamp = Lamp.Client(TMultiplexedProtocol(protocol, "Lamp"))
    vacuum_cleaner = VacuumCleaner.Client(TMultiplexedProtocol(protocol, "VacuumCleaner"))
    kettle = Kettle.Client(TMultiplexedProtocol(protocol, "Kettle"))

    def run_fridge_command():
        print("-- Run a fridge command")
        print("-- Please use the format <command_number>#<arg1>|<arg2>|...|<argN>")
        print("1: Get state          | arg1 = id")
        print("2: Turn on            | arg1 = id")
        print("3: Turn off           | arg1 = id")
        print("4: Set temperature    | arg1 = id | arg2 = value [INTEGER from -10 to 10]")
        print("5: Get temperature    | arg1 = id")

        try:
            target = input()
            fridge_command = target.split("#")
            fridge_command_number, fridge_command_arguments = fridge_command[0], fridge_command[1]

            if fridge_command_number == '1':
                print(fridge.getState(fridge_command_arguments))
            elif fridge_command_number == '2':
                print(fridge.turnOn(fridge_command_arguments))
            elif fridge_command_number == '3':
                print(fridge.turnOff(fridge_command_arguments))
            elif fridge_command_number == '4':
                fridge_id, fridge_value = fridge_command_arguments.split('|')
                fridge_value = int(fridge_value)
                print(fridge.setTemperature(fridge_id, fridge_value))
            elif fridge_command_number == '5':
                print(fridge.getTemperature(fridge_command_arguments))
            else:
                print("Invalid fridge command number! Try again...")

        except (IndexError, ValueError):
            print("Invalid input format. Please use the format <command_number>#<arg1>|<arg2>|...|<argN>")
        except (CustomException, TTransportException) as error:
            print(f"An error occurred: {error}")

    def run_lamp_command():
        print("-- Run a lamp command")
        print("-- Run a command like this -> <command_number>#<arg1>|<arg2>|...|<argN>")
        print("1: Get state         | arg1 = id")
        print("2: Turn on           | arg1 = id")
        print("3: Turn off          | arg1 = id")
        print("4: Set color         | arg1 = id | arg2 = color [0=BLUE, 1=GREEN, 2=YELLOW, 3=RED]")
        print("5: Get color         | arg1 = id")
        print("6: Set intensity     | arg1 = id | arg2 = value [INTEGER from 0 to 100]")
        print("7: Get intensity     | arg1 = id")

        try:
            target = input()
            lamp_command = target.split("#")
            lamp_command_number, lamp_command_arguments = lamp_command[0], lamp_command[1]

            if lamp_command_number == '1':
                print(lamp.getState(lamp_command_arguments))
            elif lamp_command_number == '2':
                print(lamp.turnOn(lamp_command_arguments))
            elif lamp_command_number == '3':
                print(lamp.turnOff(lamp_command_arguments))
            elif lamp_command_number == '4':
                args = lamp_command_arguments.split("|")
                lamp_id = args[0]
                lamp_color = int(args[1])
                if lamp_color == 0:
                    print(lamp.setColor(lamp_id, Lamp.LightColor.BLUE))
                elif lamp_color == 1:
                    print(lamp.setColor(lamp_id, Lamp.LightColor.GREEN))
                elif lamp_color == 2:
                    print(lamp.setColor(lamp_id, Lamp.LightColor.YELLOW))
                elif lamp_color == 3:
                    print(lamp.setColor(lamp_id, Lamp.LightColor.RED))
                else:
                    print("Invalid lamp color number! Try again...")
            elif lamp_command_number == '5':
                print(lamp.getColor(lamp_command_arguments))
            elif lamp_command_number == '6':
                args = lamp_command_arguments.split("|")
                lamp_id = args[0]
                lamp_intensity = int(args[1])
                print(lamp.setIntensity(lamp_id, lamp_intensity))
            elif lamp_command_number == '7':
                print(lamp.getIntensity(lamp_command_arguments))
            else:
                print("Invalid lamp command number! Try again...")

        except (IndexError, ValueError):
            print("Invalid input format. Please use the format <command_number>#<arg1>|<arg2>|...|<argN>")
        except (CustomException, TTransportException) as error:
            print(f"An error occurred: {error}")

    def run_vaccum_cleaner_command():
        print("-- Run a vacuum cleaner command")
        print("-- Run a command like this -> <command_number>#<arg1>|<arg2>|...|<argN>")
        print("1: Get state             | arg1 = id")
        print("2: Turn on               | arg1 = id")
        print("3: Turn off              | arg1 = id")
        print("4: Get battery level     | arg1 = id")
        print("5: Charge up             | arg1 = id")
        print("6: Get capacity          | arg1 = id")
        print("7: Empty                 | arg1 = id")

        try:
            target = input()
            vacuum_cleaner_command = target.split("#")
            vacuum_cleaner_command_number, vacuum_cleaner_command_arguments = vacuum_cleaner_command[0], \
                vacuum_cleaner_command[1]

            if vacuum_cleaner_command_number == '1':
                print(vacuum_cleaner.getState(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '2':
                print(vacuum_cleaner.turnOn(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '3':
                print(vacuum_cleaner.turnOff(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '4':
                print(vacuum_cleaner.getBattery(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '5':
                print(vacuum_cleaner.chargeUp(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '6':
                print(vacuum_cleaner.getCapacity(vacuum_cleaner_command_arguments))
            elif vacuum_cleaner_command_number == '7':
                print(vacuum_cleaner.empty(vacuum_cleaner_command_arguments))
            else:
                print("Invalid vacuum cleaner command number! Try again...")

        except (IndexError, ValueError):
            print("Invalid input format. Please use the format <command_number>#<arg1>|<arg2>|...|<argN>")
        except (CustomException, TTransportException) as error:
            print(f"An error occurred: {error}")

    def run_kettle_command():
        print("-- Run a kettle command")
        print("-- Run a command like this -> <command_number>#<arg1>|<arg2>|...|<argN>")

        print("1: Get state             | arg1 = id")
        print("2: Turn on               | arg1 = id")
        print("3: Turn off              | arg1 = id")
        print("4: Set water temperature           | arg1 = id | arg2 = channel [INTEGER from 0 to 100]")
        print("5: Get water temperature           | arg1 = id")

        try:
            target = input()
            kettle_command = target.split("#")
            kettle_command_number, kettle_command_arguments = kettle_command[0], kettle_command[1]

            if kettle_command_number == '1':
                print(kettle.getState(kettle_command_arguments))
            elif kettle_command_number == '2':
                print(kettle.turnOn(kettle_command_arguments))
            elif kettle_command_number == '3':
                print(kettle.turnOff(kettle_command_arguments))
            elif kettle_command_number == '4':
                args = kettle_command_arguments.split("|")
                kettle_id = args[0]
                kettle_temperature = int(args[1])
                print(kettle.setTemperature(kettle_id, kettle_temperature))
            elif kettle_command_number == '5':
                print(kettle.getTemperature(kettle_command_arguments))
            else:
                print("Invalid kettle command number! Try again...")

        except (IndexError, ValueError):
            print("Invalid input. Please use the format <command_number>#<arg1>|<arg2>|...|<argN>")
        except (CustomException, TTransportException) as error:
            print(f"An error occurred: {error}")

    print(f"Trying to connect to {home_name} ({address}:{port})...")
    time.sleep(1)

    try:
        trans.open()
        print(f"Connected successfully to {home_name} ({address}:{port})!")
        time.sleep(1)

        while True:
            os.system("cls")

            print(f"-- SMART HOME MANAGER [{home_name} - {address}:{port}]")
            print("-- Choose number to run a command")
            print("1: List all devices")
            print("2: Run a fridge command")
            print("3: Run a lamp command")
            print("4: Run a vacuum cleaner command")
            print("5: Run a kettle command")
            print("6: Go to menu")
            print("7: Exit")

            command_number = input()
            print()
            match command_number:
                case "1":
                    for dev in device.listAllDevices():
                        print(dev)
                case "2":
                    run_fridge_command()
                case "3":
                    run_lamp_command()
                case "4":
                    run_vaccum_cleaner_command()
                case "5":
                    run_kettle_command()
                case "6":
                    trans.close()
                    break
                case "7":
                    trans.close()
                    sys.exit()
                case default:
                    print("Invalid command number! Try again...")

            print()
            print("Press any key to continue...")
            input()

        main()

    except (TTransportException, ConnectionResetError) as error:
        print("There was a problem with the network communication with the home server.")
        print(f"Error: {error}")
        print("Please check your network connection and try again.")
        print("Do you want to try to reconnect? Type 'Y' to try again or 'N' to go back to the menu.")

        target = input()
        if target == 'Y':
            connect_to_home_server(home_name, address, port)
        elif target == 'N':
            main()
        else:
            print("Invalid command!")
            print()
            print("Press any key to continue...")
            input()
            main()


def main():
    os.system("cls")

    print("-- SMART HOME MANAGER")
    print("-- Choose home to connect")
    print("1: Home 1")
    print("2: Home 2")
    print("3: Exit")

    home_number = input()

    if home_number == '1':
        connect_to_home_server("Home 1", "localhost", 9010)
    elif home_number == '2':
        connect_to_home_server("Home 2", "localhost", 9020)
    elif home_number == '3':
        os.system("cls")
        print("Thank you for using SMART HOME MANAGER!")
        sys.exit()
    else:
        print("Invalid argument! Try again...")
        print()
        print("Press any key to continue...")
        input()
        main()


if __name__ == "__main__":
    main()