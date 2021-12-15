package frc.robot.CentralComponents;

// Declare imports for the Joystick, Solenoids, Sparks, and Compressor
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

// Declare the components used for the robot (Joystick, Solenoids, Sparks, and
// Compressor)
public class Components {
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
    public static XboxController Xbox = new XboxController(0);
    public static Joystick contRC = new Joystick(0);
    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}
