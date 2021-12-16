package frc.robot;

//Import the central system for the components
import frc.robot.CentralComponents.*;

// Button numbers: [1: X] [2: A] [3: B] [4: Y] [5: LB] [6: RB] [7: LT] [8: RT]
// [9: BACK] [10: START] [11: Left joystick] [12: Right joystick]

public class DrivetrainXbox {

    /*
     * public static Spark leftMotor = new Spark(0); public static Spark rightMotor
     * = new Spark(1); public static Spark elevator = new Spark(2); public static
     * XboxController cont = new XboxController(0); public static Solenoid beakOpen
     * = new Solenoid(0); public static Solenoid beakClose = new Solenoid(1); public
     * static Solenoid headFlatten = new Solenoid(2); public static Solenoid
     * headExtend = new Solenoid(3); public static Compressor compressor = new
     * Compressor(0);
     */
    // Method that runs when teleop is started
    public static void teleopInit() {

        // Sets the left motor to inverted
        Components.leftMotor.setInverted(true);

        // Set pulse duration for all Solenoids (pneumatics)
        Components.beakOpen.setPulseDuration(0.5);
        Components.beakClose.setPulseDuration(0.5);
        Components.headFlatten.setPulseDuration(0.5);

        // Defaults the compressor to off
        Components.compressor.stop();
    }

    // Main drive method
    public static void drive() {

        // Set default speed mofifiers
        double speedModifierElevator = 0.25;
        double speedModifierDriving = 0.3;

        // Sets the speed modifiers depending on which button is pressed

        if (Components.cont.getRawButton(8)) { // Faster
            speedModifierElevator = 0.5;
            speedModifierDriving = 0.5;

        } else if (Components.cont.getRawButton(6)) { // Slower
            speedModifierElevator = 0.2;
            speedModifierDriving = 0.1;

        } else { // Default
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.3;
        }

        // Set motors to the respective joystick's position multiplied by the speed
        // modifier
        Components.leftMotor.set(Components.cont.getRawAxis(3) * speedModifierDriving);
        Components.rightMotor.set(Components.cont.getRawAxis(1) * speedModifierDriving);

        // Elevator controls [Back Left buttons]
        if (Components.cont.getRawButton(5))
            Components.elevator.set(speedModifierElevator);
        else if (Components.cont.getRawButton(7))
            Components.elevator.set(-speedModifierElevator);
        else
            Components.elevator.set(0);

        // Start compressor [START]
        if (Components.cont.getRawButtonPressed(10))
            Components.compressor.start();

        // Stop compressor [BACK]
        if (Components.cont.getRawButtonPressed(9))
            Components.compressor.stop();

        // Open beak [Button X]
        if (Components.cont.getRawButtonPressed(1))
            Components.beakOpen.startPulse();

        // Close beak [Button A]
        if (Components.cont.getRawButtonPressed(2))
            Components.beakClose.startPulse();

        // Flatten head [B]
        if (Components.cont.getRawButtonPressed(3))
            Components.headFlatten.startPulse();

        // Extend head [Y]
        if (Components.cont.getRawButtonPressed(4))
            Components.headExtend.startPulse();
    }
}