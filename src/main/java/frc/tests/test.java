/*
package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;

public class test {
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    // public static Joystick cont = new Joystick(0);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);
    public static Solenoid raiseFront = new Solenoid(4);
    public static Solenoid raiseBack = new Solenoid(5);

    static Integer counter = 0;
    public static void drive() {
        beakOpen.startPulse();
        while ( ! (counter == 50000)) {
            counter++;
        }
        beakClose.startPulse();
    }
}
*/