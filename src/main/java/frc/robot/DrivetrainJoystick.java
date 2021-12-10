package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;

public class DrivetrainJoystick {

    private static boolean beak = true;
    private static boolean head = true;
    private static boolean backPistons = false;
    private static boolean frontPistons = false;
    private static boolean compressorToggle = true;
    private static double left;
    private static double right;
    private static double speedModifierDriving = 0.5;
    private static double speedModifierElevator = 0.25;
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    public static Joystick cont = new Joystick(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Solenoid pistonsFront = new Solenoid(4);
    public static Solenoid pistonsBack = new Solenoid(5);
    public static Compressor compressor = new Compressor();

    public static void teleopInit() {
        leftMotor.setInverted(true);
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        pistonsFront.setPulseDuration(0.5);
        pistonsBack.setPulseDuration(0.5);
        compressor.stop();
    }

    public static void drive() {

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

        // Front piston toggle [11]
        if (cont.getRawButtonPressed(11)) {
            if (frontPistons) {
                pistonsFront.set(true);
                frontPistons = false;
            } else if (!frontPistons) {
                pistonsFront.set(false);
                frontPistons = true;
            }
        }

        // Back piston toggle [12]
        if (cont.getRawButtonPressed(12)) {
            if (backPistons) {
                pistonsBack.set(true);
                backPistons = false;
            } else if (!backPistons) {
                pistonsBack.set(false);
                backPistons = true;
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
            if (beak) {
                beakClose.startPulse();
                beak = false;
            } else if (!beak) {
                beakOpen.startPulse();
                beak = true;
            }
        }

        // Toggle head [4]
        if (cont.getRawButtonPressed(4)) {
            if (head) {
                headFlatten.startPulse();
                head = false;
            } else if (!head) {
                headExtend.startPulse();
                head = true;
            }
        }
    }
}
