package frc.robot;

import frc.robot.CentralComponents.*;

public class PIDgyro {
    // Declare PID constants
    private static double kP = 0.5; // ~0.5
    private static double kI = 0.01; // ~0.01
    private static double kD = 1; // ~ 4

    // Declare fix variables
    private static double proportionalFix;
    private static double integralFix;
    private static double derivativeFix;

    // Declare other variables
    private static double last_error = 0;

    private static double integralCount;
    private static double derivativeCount;

    public static void gyroInit() {
        Components.gyro.reset();
    }

    public static void gyroDrive() {

        // Calculate error
        double error = (Components.gyro.getAngle() - 50);

        //Calculate proportional fix (last deviation)
        proportionalFix = error * kP;

        //Calculate integral fix (total deviation)
        integralCount = integralCount + error;
        integralFix = integralCount * kI;

        //Calculate derivative fix (rate of deviation)
        derivativeCount = error - last_error;
        last_error = error;
        derivativeFix = derivativeCount * kD;
        
        //Set motors to calculated values
        Components.leftMotor.set(0.2 + (proportionalFix + integralFix + derivativeFix));
        Components.rightMotor.set(0.2 - (proportionalFix + integralFix + derivativeFix));
    }
}
