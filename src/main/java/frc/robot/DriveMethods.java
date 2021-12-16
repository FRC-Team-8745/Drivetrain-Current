package frc.robot;

import frc.robot.CentralComponents.Components;

public class DriveMethods {
    public static void steeringNumDrive(double steering, double speedMod) {
        Components.leftMotor.set(steering * speedMod);
        Components.rightMotor.set(-steering * speedMod);
    }
}
