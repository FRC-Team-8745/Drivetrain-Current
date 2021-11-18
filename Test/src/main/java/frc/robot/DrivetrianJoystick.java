package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;

public class DrivetrianJoystick {

    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    public static Joystick cont = new Joystick(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);
    public static Solenoid raiseFront = new Solenoid(4);
    public static Solenoid raiseBack = new Solenoid(5);
    public static double left;
    public static double right;
    public static double speedModifierElevator = 0.25;
    public static double speedModifierDriving = 0.3;
    public static boolean beakToggle = true;
    public static boolean headToggle = true;
    public static boolean compressorToggle = true;
    public static boolean frontPistonToggle = true;
    public static boolean backPistonToggle = true;

    public static void initialize() {
        beakOpen.startPulse();
        beakToggle = false;
        headToggle = false;
        compressorToggle = true;
        frontPistonToggle = true;
        backPistonToggle = true;
        leftMotor.setInverted(true);
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        headExtend.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        raiseFront.setPulseDuration(0.5);
        raiseBack.setPulseDuration(0.5);
    }

    public static void drive() {



        /*
         * Button numbers: [1: trigger] [2: sidebutton] [3:labeled] [4: labeled] [5:
         * labeled] [6: labeled] [7: labeled] [8: labeled] [9: labeled] [10: labeled]
         * [11: labeled] [12: labeled]
         */

        // Speed modifiers
        if (cont.getRawButton(1)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.5;
        }

        // Set motors to controller position, using speed modifier

        right = -cont.getRawAxis(1) * 0.5 + cont.getRawAxis(0) * 0.5;
        left = -cont.getRawAxis(1) * 0.5 - cont.getRawAxis(0) * 0.5;

        leftMotor.set(left * speedModifierDriving);
        rightMotor.set(right * speedModifierDriving);

        // Elevator controls [5+3]
        if (cont.getRawButton(5)) {
            elevator.set(speedModifierElevator);
        } else if (cont.getRawButton(3)) {
            elevator.set(-speedModifierElevator);
        } else {
            elevator.set(0);
        }

        // Front piston toggle [11]
        if (cont.getRawButtonPressed(11)) {
            if (frontPistonToggle) {
                raiseFront.set(true);
                frontPistonToggle = false;
            } else if (!frontPistonToggle) {
                raiseFront.set(false);
                frontPistonToggle = true;
            }
        }

        // Back piston toggle [12]
        if (cont.getRawButtonPressed(12)) {
            if (backPistonToggle) {
                raiseBack.set(true);
                backPistonToggle = false;
            } else if (!backPistonToggle) {
                raiseBack.set(false);
                backPistonToggle = true;
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
            if (beakToggle) {
                beakClose.startPulse();
                beakToggle = false;
            } else if (!beakToggle) {
                beakOpen.startPulse();
                beakToggle = true;
            }
        }

        // Toggle head [4]
        if (cont.getRawButtonPressed(4)) {
            if (headToggle) {
                headFlatten.startPulse();
                headToggle = false;
            } else if (!headToggle) {
                headExtend.startPulse();
                headToggle = true;
            }
        }
    }
}