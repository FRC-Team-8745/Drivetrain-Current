package frc.robot;

// Declare imports for the Joystick, Solenoids, Sparks, and Compressor
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;

public class DrivetrainJoystick {

    // Set default state for the toggleable components
    private static boolean beak = true;
    private static boolean head = true;
    private static boolean backPistons = false;
    private static boolean frontPistons = false;
    private static boolean compressorToggle = true;

    // Declare variables for the two driving motors and set default speed mofifiers
    private static double left;
    private static double right;
    private static double speedModifierDriving = 0.5;
    private static double speedModifierElevator = 0.25;

    // Declare the components used for the robot (Joystick, Solenoids, Sparks, and
    // Compressor)
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    public static Joystick cont = new Joystick(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Solenoid pistonsFront = new Solenoid(4);
    public static Solenoid pistonsBack = new Solenoid(5);
    public static Compressor compressor = new Compressor();

    // Method that runs when teleop is started
    public static void teleopInit() {

        // Sets the left motor to inverted
        leftMotor.setInverted(true);

        // Set pulse duration for all Solenoids (pneumatics)
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        headExtend.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        pistonsFront.setPulseDuration(0.5);
        pistonsBack.setPulseDuration(0.5);

        // Defaults the compressor to off
        compressor.stop();
    }

    // Main drive method
    public static void drive() {

        // Set the speed modifier depending on wether or not the trigger(1) on the
        // joystick is held down
        if (cont.getRawButton(1)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.5;
        }
        // Controls the elevator based on wether or not the top left buttons(5;3) are
        // pressed
        if (cont.getRawButton(5))
            elevator.set(speedModifierElevator);
        else if (cont.getRawButton(3))
            elevator.set(-speedModifierElevator);
        else
            elevator.set(0);

        // Set variables for the left and right motors to the controllers axis, using
        // both the up/down and left/right values and some math
        right = -cont.getRawAxis(1) * 0.5 + cont.getRawAxis(0) * 0.5;
        left = -cont.getRawAxis(1) * 0.5 - cont.getRawAxis(0) * 0.5;

        // Set the motors to the speed determined above multiplied by the speed modifier
        leftMotor.set(left * speedModifierDriving);
        rightMotor.set(right * speedModifierDriving);

        /*
         * 
         * // Example toggle component module
         * 
         * if (controller button is pressed) { if (toggle variable is true) { Toggle the
         * component; Toggle the value to false; } else if (toggle variable if false) {
         * Toggle the component backwards; Toggle the value to true; } }
         * 
         */

        // Front piston toggle [11]
        if (cont.getRawButtonPressed(11)) {
            if (frontPistons) {
                pistonsFront.set(true);
                frontPistons = false;
            } else if (!frontPistons) {
                pistonsFront.set(false);
                frontPistons = true;
            }
        }

        // Back piston toggle [12]
        if (cont.getRawButtonPressed(12)) {
            if (backPistons) {
                pistonsBack.set(true);
                backPistons = false;
            } else if (!backPistons) {
                pistonsBack.set(false);
                backPistons = true;
            }
        }

        // Toggle compressor [8]
        if (cont.getRawButtonPressed(8)) {
            if (compressorToggle) {
                compressor.start();
                compressorToggle = false;
            } else if (!compressorToggle) {
                compressor.stop();
                compressorToggle = true;
            }
        }

        // Toggle beak [6]
        if (cont.getRawButtonPressed(6)) {
            if (beak) {
                beakClose.startPulse();
                beak = false;
            } else if (!beak) {
                beakOpen.startPulse();
                beak = true;
            }
        }

        // Toggle head [4]
        if (cont.getRawButtonPressed(4)) {
            if (head) {
                headFlatten.startPulse();
                head = false;
            } else if (!head) {
                headExtend.startPulse();
                head = true;
            }
        }
    }
}