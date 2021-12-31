package frc.robot;

import frc.robot.CentralComponents.ComponentsSweeper;

// Button numbers: [1: X] [2: A] [3: B] [4: Y] [5: LB] [6: RB] [7: LT] [8: RT]
// [9: BACK] [10: START] [11: Left joystick] [12: Right joystick]

public class Sweeper {
    public static void drive() {
        // set your speeds
        double speed = 0.4;
        double grabber = 0.4;
        // drivetrain
        ComponentsSweeper.leftMotor.set((ComponentsSweeper.Xbox.getRawAxis(1) * speed));
        ComponentsSweeper.rightMotor.set((ComponentsSweeper.Xbox.getRawAxis(3) * speed));

        // graber on Sweeper
        if (ComponentsSweeper.Xbox.getRawButton(8))
            ComponentsSweeper.broom.set(grabber);
        else if (ComponentsSweeper.Xbox.getRawButton(7))
            ComponentsSweeper.broom.set(-grabber);
        else
            ComponentsSweeper.broom.set(0);

        // piston controls
        if (ComponentsSweeper.Xbox.getRawButtonPressed(2)) {
            if (ComponentsSweeper.compressor.enabled())
                ComponentsSweeper.compressor.stop();
            else
                ComponentsSweeper.compressor.start();

        }
        if (ComponentsSweeper.Xbox.getRawButtonPressed(3))
            ComponentsSweeper.fourBar.toggle();

    }
}