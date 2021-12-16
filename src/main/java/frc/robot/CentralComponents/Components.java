package frc.robot.CentralComponents;

// Declare imports for the Joystick, Solenoids, Sparks, and Compressor
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;

// Declare the components used for the robot (Joystick, Solenoids, Sparks, and
// Compressor)
public class Components {
    public static DoubleSolenoid beak = new DoubleSolenoid(0, 1);
    public static DoubleSolenoid head = new DoubleSolenoid(3, 2);
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    public static Joystick cont = new Joystick(0);
    // front/back pistons
    public static Solenoid pistonsFront = new Solenoid(4);
    public static Solenoid pistonsBack = new Solenoid(5);
    // controllers
    public static Compressor compressor = new Compressor();
    public static XboxController Xbox = new XboxController(0);
    public static Joystick contRC = new Joystick(0);
}
