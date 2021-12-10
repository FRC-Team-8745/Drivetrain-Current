package frc.robot;

//Import the central system for the components
import frc.robot.CentralComponents.*;

public class DrivetrainRC {

    // Method that runs when teleop is started
    public static void teleopInit() {
        // Sets the left motor to inverted
        Components.leftMotor.setInverted(true);
    }

    // Main drive method
    public static void drive() {

        // Set the motors to the value of the trigger position, multiplied by 0.5
        Components.rightMotor.set(Components.cont.getRawAxis(1) * 0.5);
        Components.leftMotor.set(Components.cont.getRawAxis(1) * 0.5);

        // Uses the wheel to control steering by checking if the value is greater or
        // less than 0 and setting the right or left motor to the total value
        // respectively
        if (Components.cont.getRawAxis(0) > 0) {
            Components.rightMotor.set(Components.contRC.getRawAxis(0) * 0.5);
        }
        if (Components.cont.getRawAxis(0) < 0) {
            Components.leftMotor.set(Components.contRC.getRawAxis(0) * 0.5);
        }
    }
}