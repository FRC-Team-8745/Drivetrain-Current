package frc.robot;

import frc.robot.CentralComponents.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class shuffleboard {
    public static void displayContent() {
        SmartDashboard.putNumber("Joystick X value", Components.cont.getX());
        SmartDashboard.putNumber("Gyro Angle", Components.gyro.getAngle());
        SmartDashboard.putNumber("Right Encoder", Components.rightMotorEncoder.getDistance());
        SmartDashboard.putNumber("Left Encoder", Components.leftMotorEncoder.getDistance());
    }
}