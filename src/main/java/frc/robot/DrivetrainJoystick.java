package frc.robot;

//Import the central system for the components
import frc.robot.CentralComponents.*;

/*
 * Button numbers: [1: trigger] [2: sidebutton] [3:labeled] [4: labeled] [5:
 * labeled] [6: labeled] [7: labeled] [8: labeled] [9: labeled] [10: labeled]
 * [11: labeled] [12: labeled]
 */

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

    // Method that runs when teleop is started
    public static void teleopInit() {

        // Sets the left motor to inverted
        Components.leftMotor.setInverted(true);

        // Set pulse duration for all Solenoids (pneumatics)
        Components.beakOpen.setPulseDuration(0.5);
        Components.beakClose.setPulseDuration(0.5);
        Components.headFlatten.setPulseDuration(0.5);
        Components.pistonsFront.setPulseDuration(0.5);
        Components.pistonsBack.setPulseDuration(0.5);

        // Defaults the compressor to off
        Components.compressor.stop();
        
        // Resets the gyro
        Components.gyro.reset();
    }

    // Main drive method
    public static void drive() {

        // Set the speed modifier depending on wether or not the trigger(1) on the
        // joystick is held down
        if (Components.cont.getRawButton(1)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.5;
        }

        // Set variables for the left and right motors to the controllers axis, using
        // both the up/down and left/right values and some math
        right = -Components.cont.getRawAxis(1) * 0.5 + Components.cont.getRawAxis(0) * 0.5;
        left = -Components.cont.getRawAxis(1) * 0.5 - Components.cont.getRawAxis(0) * 0.5;

        // Set the motors to the speed determined above multiplied by the speed modifier
        Components.leftMotor.set(left * speedModifierDriving);
        Components.rightMotor.set(right * speedModifierDriving);

        // Elevator controls [5+3]
        if (Components.cont.getRawButton(5))
            // Move elevator upwards using the speed modifier
            Components.elevator.set(speedModifierElevator);
        else if (Components.cont.getRawButton(3))
            // Move elevator downwards using the speed modifier
            Components.elevator.set(-speedModifierElevator);
        else
            // Set elevator speed to 0 if neither of the buttons are pressed
            Components.elevator.set(0);

        // Front piston toggle [11]
        if (Components.cont.getRawButtonPressed(11)) {
            if (frontPistons) {
                Components.pistonsFront.set(true);
                frontPistons = false;
            } else if (!frontPistons) {
                Components.pistonsFront.set(false);
                frontPistons = true;
            }
        }

        // Back piston toggle [12]
        if (Components.cont.getRawButtonPressed(12)) {
            if (backPistons) {
                Components.pistonsBack.set(true);
                backPistons = false;
            } else if (!backPistons) {
                Components.pistonsBack.set(false);
                backPistons = true;
            }
        }

        // Toggle compressor [8]
        if (Components.cont.getRawButtonPressed(8)) {
            if (compressorToggle) {
                Components.compressor.start();
                compressorToggle = false;
            } else if (!compressorToggle) {
                Components.compressor.stop();
                compressorToggle = true;
            }
        }

        // Toggle beak [6]
        if (Components.cont.getRawButtonPressed(6)) {
            if (beak) {
                Components.beakClose.startPulse();
                beak = false;
            } else if (!beak) {
                Components.beakOpen.startPulse();
                beak = true;
            }
        }

        // Toggle head [4]
        if (Components.cont.getRawButtonPressed(4)) {
            if (head) {
                Components.headFlatten.startPulse();
                head = false;
            } else if (!head) {
                Components.headExtend.startPulse();
                head = true;
            }
        }
    }
}