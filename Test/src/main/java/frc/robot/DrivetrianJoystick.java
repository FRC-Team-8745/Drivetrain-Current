package frc.robot;

import frc.birdie.components;

public class DrivetrianJoystick {
    private static boolean beak = true;
    private static boolean head = true;
    private static boolean backPistons = false;
    private static boolean frontPistons = false;
    private static boolean compressor = true;
    private static double left;
    private static double right;
    private static double speedModifierElevator = 0.25;
    private static double speedModifierDriving = 0.3;

    /*
     * Button numbers: [1: trigger] [2: sidebutton] [3:labeled] [4: labeled] [5:
     * labeled] [6: labeled] [7: labeled] [8: labeled] [9: labeled] [10: labeled]
     * [11: labeled] [12: labeled]
     */

    public static void initialize() {
        components.beakOpen.startPulse();
    }

    public static void drive() {

        // Speed modifiers
        if (components.cont.getRawButton(1)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.5;
        }
    }

    {

        // Set motors to controller position, using speed modifier

        right = -components.cont.getRawAxis(1) * 0.5 + components.cont.getRawAxis(0) * 0.5;
        left = -components.cont.getRawAxis(1) * 0.5 - components.cont.getRawAxis(0) * 0.5;

        components.leftMotor.set(left * speedModifierDriving);
        components.rightMotor.set(right * speedModifierDriving);

        // Elevator controls [5+3]
        if (components.cont.getRawButton(5)) {
            components.elevator.set(speedModifierElevator);
        } else if (components.cont.getRawButton(3)) {
            components.elevator.set(-speedModifierElevator);
        } else {
            components.elevator.set(0);
        }

        if (components.cont.getRawButton(2)) {

        }

        // Front piston toggle [11]
        if (frontPistons) {
            components.pistonsFront.set(true);
            frontPistons = false;
        } else if (!frontPistons) {
            components.pistonsFront.set(false);
            frontPistons = true;
        }

        // Back piston toggle [12]
        if (backPistons) {
            components.pistonsBack.set(true);
            backPistons = false;
        } else if (!backPistons) {
            components.pistonsBack.set(false);
            backPistons = true;
        }

        // Toggle compressor [8]
        if (compressor) {
            components.compressor.start();
            compressor = false;
        } else if (!compressor) {
            components.compressor.stop();
            compressor = true;
        }
    }

    {

        // Toggle beak [6]
        if (beak) {
            components.beakClose.startPulse();
            beak = false;
        } else if (!beak) {
            components.beakOpen.startPulse();
            beak = true;
        }

        // Toggle head [4]
        if (head) {
            components.headFlatten.startPulse();
            head = false;
        } else if (!head) {
            components.headExtend.startPulse();
            head = true;
        }
    }
}