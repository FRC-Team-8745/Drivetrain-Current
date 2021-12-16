package frc.robot;

// Declare imports for the Joystick, Solenoids, Sparks, and Compressor
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Compressor;

// Button numbers: [1: X] [2: A] [3: B] [4: Y] [5: LB] [6: RB] [7: LT] [8: RT]
// [9: BACK] [10: START] [11: Left joystick] [12: Right joystick]

public class DrivetrainXbox {

    // Declare the components used for the robot (Joystick, Solenoids, Sparks, and
    // Compressor)
    public static Spark leftMotor = new Spark(0);
    public static Spark rightMotor = new Spark(1);
    public static Spark elevator = new Spark(2);
    public static XboxController cont = new XboxController(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);

    // Method that runs when teleop is started
    public static void teleopInit() {

        // Sets the left motor to inverted
        leftMotor.setInverted(true);

        // Set pulse duration for all Solenoids (pneumatics)
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);

        // Defaults the compressor to off
        compressor.stop();
    }

    // Main drive method
    public static void drive() {

        // Set default speed mofifiers
        double speedModifierElevator = 0.25;
        double speedModifierDriving = 0.3;

        // Sets the speed modifiers depending on which button is pressed

            // Faster
        if (cont.getRawButton(8)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 0.5;
            // Slower
        } else if (cont.getRawButton(6)) {
            speedModifierElevator = 0.2;
            speedModifierDriving = 0.1;
            // Default
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.3;
        }

        // Set motors to the respective joystick's position multiplied by the speed
        // modifier
        leftMotor.set(cont.getRawAxis(3) * speedModifierDriving);
        rightMotor.set(cont.getRawAxis(1) * speedModifierDriving);

        // Elevator controls [Back Left buttons]
        if (cont.getRawButton(5))
            elevator.set(speedModifierElevator);
        else if (cont.getRawButton(7))
            elevator.set(-speedModifierElevator);
        else
            elevator.set(0);

        // Start compressor [START]
        if (cont.getRawButtonPressed(10))
            compressor.start();

        // Stop compressor [BACK]
        if (cont.getRawButtonPressed(9))
            compressor.stop();

        // Open beak [Button X]
        if (cont.getRawButtonPressed(1))
            beakOpen.startPulse();

        // Close beak [Button A]
        if (cont.getRawButtonPressed(2))
            beakClose.startPulse();

        // Flatten head [B]
        if (cont.getRawButtonPressed(3))
            headFlatten.startPulse();

        // Extend head [Y]
        if (cont.getRawButtonPressed(4))
            headExtend.startPulse();
    }
}