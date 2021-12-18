package frc.robot.CentralComponents;

// Declare imports for the Joystick, Solenoids, Sparks, and Compressor
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// Declare the components used for the robot (Joystick, Solenoids, Sparks, and
// Compressor)
public class Components {
    // Method declarations

    // Double solenoids for the beak and head
    public static DoubleSolenoid beak = new DoubleSolenoid(0, 1);
    public static DoubleSolenoid head = new DoubleSolenoid(3, 2);

    // Solenoids for the front and back pistons
    public static Solenoid pistonsFront = new Solenoid(4);
    public static Solenoid pistonsBack = new Solenoid(5);

    // Sparks for the elevator and wheels
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);

    // Compressor
    public static Compressor compressor = new Compressor();

    // Controllers
    public static Joystick cont = new Joystick(0);
    public static XboxController Xbox = new XboxController(0);
    public static Joystick contRC = new Joystick(0);

    // This method runs when the robot is first turned on and it sets the default
    // positions, states, and values of all components
    public static void init() {
        // Set double solenoid base values
        head.set(Value.kForward);
        beak.set(Value.kForward);

        // Set single solenoid base values
        pistonsFront.set(false);
        pistonsBack.set(false);

        // Sets the left motor to inverted
        leftMotor.setInverted(true);

        /*
         * Closed loop control automatically enables the compressor at 0 psi and
         * disables it at ~120 psi. This isn't useful in our programs, as we only ever
         * charge it to ~40 psi. Open loop control allows only manual enabling/disabling
         * of the compressor, which is what we use.
         */

        // Defaults the compressor to off and to open loop control
        compressor.setClosedLoopControl(false);
        compressor.stop();

    }
}
