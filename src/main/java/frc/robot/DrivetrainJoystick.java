package frc.robot;

import frc.birdie.components;
import frc.birdie.toggleMove;

public class DrivetrainJoystick {
    
    private static boolean beak = true;
    private static boolean head = true;
    private static boolean backPistons = false;
    private static boolean frontPistons = false;
    private static boolean compressor = true;
    private static double left;
    private static double right;
    private static double speedModifierElevator = 0.25;
    
    // Set motors to controller position, using speed modifier
    
    public static void drive() {
        
        // Speed modifiers
        if (components.cont.getRawButton(1)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.5;
        }

        // Set motors to controller position, using speed modifier

        right = -components.cont.getRawAxis(1) * 0.5 + components.cont.getRawAxis(0) * 0.5;
        left = -components.cont.getRawAxis(1) * 0.5 - components.cont.getRawAxis(0) * 0.5;

        components.leftMotor.set(left * speedModifierDriving);
        components.rightMotor.set(right * speedModifierDriving);

        speedModifierElevator = 0.25;
        speedModifierDriving = 0.5;
        
        // Front piston toggle [11]
        if (components.cont.getRawButtonPressed(11)) {
            if (frontPistons) {
                components.pistonsFront.set(true);
                frontPistons = false;
            } else if (!frontPistons) {
                components.pistonsFront.set(false);
                frontPistons = true;
            }
        }
        
        // Back piston toggle [12]
        if (components.cont.getRawButtonPressed(12)) {
            if (backPistons) {
                components.pistonsBack.set(true);
                backPistons = false;
            } else if (!backPistons) {
                components.pistonsBack.set(false);
                backPistons = true;
            }
        }
        
        // Toggle compressor [8]
        if (components.cont.getRawButtonPressed(8)) {
            if (compressor) {
                components.compressor.start();
                compressor = false;
            } else if (!compressor) {
                components.compressor.stop();
                compressor = true;
            }
        }
        
        
        
        // Toggle beak [6]
        if (components.cont.getRawButtonPressed(6)) {
            if (beak) {
                components.beakClose.startPulse();
                beak = false;
            } else if (!beak) {
                components.beakOpen.startPulse();
                beak = true;
            }
        }
        
        // Toggle head [4]
        if (components.cont.getRawButtonPressed(4)) {
            if (head) {
                components.headFlatten.startPulse();
                head = false;
            } else if (!head) {
                components.headExtend.startPulse();
                head = true;
            }
        }
    }
}


