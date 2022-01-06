package frc.robot;

//Import the central system for the components
import frc.robot.CentralComponents.*;

/*
 * Button numbers: [1: trigger] [2: sidebutton] [3:labeled] [4: labeled] [5:
 * labeled] [6: labeled] [7: labeled] [8: labeled] [9: labeled] [10: labeled]
 * [11: labeled] [12: labeled]
 */

public class DrivetrainJoystick {

    // Declare variables for the speed modifiers
    private static double speedModifierDriving;
    private static double speedModifierElevator;

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
        // both the up/down and left/right values and some math; multiplied by the speed
        // modifier
        Components.leftMotor.set(
                (-Components.cont.getRawAxis(1) * 0.5 - Components.cont.getRawAxis(0) * 0.5) * speedModifierDriving);
        Components.rightMotor.set(
                (-Components.cont.getRawAxis(1) * 0.5 + Components.cont.getRawAxis(0) * 0.5) * speedModifierDriving);

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
        if (Components.cont.getRawButtonPressed(11))
            Components.pistonsFront.toggle();

        // Back piston toggle [12]
        if (Components.cont.getRawButtonPressed(12))
            Components.pistonsBack.toggle();

        // Toggle compressor [8]
        if (Components.cont.getRawButtonPressed(8)) {
            // Read if the compressor is enabled, then use that information to disable or enable it when the button is pressed
            if (Components.compressor.enabled())
                Components.compressor.stop();
            else
                Components.compressor.start();
        }

        // Toggle beak [6]
        if (Components.cont.getRawButtonPressed(6))
            Components.beak.toggle();

        // Toggle head [4]
        if (Components.cont.getRawButtonPressed(4))
            Components.head.toggle();
    }
}