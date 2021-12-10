package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Compressor;

public class DrivetrainXbox {

    public static Spark leftMotor = new Spark(0);
    public static Spark rightMotor = new Spark(1);
    public static Spark elevator = new Spark(2);
    public static XboxController cont = new XboxController(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);

    public static void teleopInit() {
        leftMotor.setInverted(true);
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        compressor.stop();
    }

    public static void drive() {

        double speedModifierElevator = 0.25;
        double speedModifierDriving = 0.3;

        // Button numbers: [1: X] [2: A] [3: B] [4: Y] [5: LB] [6: RB] [7: LT] [8: RT]
        // [9: BACK] [10: START] [11: Left joystick] [12: Right joystick]

        // Speed modifiers
        if (cont.getRawButton(8)) {
            speedModifierElevator = 0.5;
            speedModifierDriving = 0.5;
        } else if (cont.getRawButton(6)) {
            speedModifierElevator = 0.2;
            speedModifierDriving = 0.1;
        } else {
            speedModifierElevator = 0.25;
            speedModifierDriving = 0.3;
        }

        // Set motors to controller position, using speed modifier
        leftMotor.set(cont.getRawAxis(3) * speedModifierDriving);
        rightMotor.set(cont.getRawAxis(1) * speedModifierDriving);

        // Elevator controls [Back Left buttons]
        if (cont.getRawButton(5))
            elevator.set(speedModifierElevator);
        else if (cont.getRawButton(7))
            elevator.set(-speedModifierElevator);
        else
            elevator.set(0);

        // Start compressor [START]
        if (cont.getRawButtonPressed(10))
            compressor.start();

        // Stop compressor [BACK]
        if (cont.getRawButtonPressed(9))
            compressor.stop();

        // Open beak [Button X]
        if (cont.getRawButtonPressed(1))
            beakOpen.startPulse();

        // Close beak [Button A]
        if (cont.getRawButtonPressed(2))
            beakClose.startPulse();

        // Flatten head [B]
        if (cont.getRawButtonPressed(3))
            headFlatten.startPulse();

        // Extend head [Y]
        if (cont.getRawButtonPressed(4))
            headExtend.startPulse();
    }
}