package frc.robot;

// Declare imports for the Joystick and Sparks
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;

public class DrivetrainRC {

    // Declare the components used for the robot (Joystick and Sparks)
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Joystick cont = new Joystick(0);

    // Method that runs when teleop is started
    public static void teleopInit() {
        // Sets the left motor to inverted
        leftMotor.setInverted(true);
    }

    // Main drive method
    public static void drive() {

        // Set the motors to the value of the trigger position, multiplied by 0.5
        rightMotor.set(cont.getRawAxis(1) * 0.5);
        leftMotor.set(cont.getRawAxis(1) * 0.5);

        // Uses the wheel to control steering by checking if the value is greater or
        // less than 0 and setting the right or left motor to the total value
        // respectively
        if (cont.getRawAxis(0) > 0) {
            rightMotor.set(cont.getRawAxis(0) * 0.5);
        }
        if (cont.getRawAxis(0) < 0) {
            leftMotor.set(cont.getRawAxis(0) * 0.5);
        }
    }
}