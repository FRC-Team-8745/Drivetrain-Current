package frc.robot;

//import your motor controllers, compressors, solenoids, and physical controllers using this pattern.
    import edu.wpi.first.wpilibj.XboxController;
    import edu.wpi.first.wpilibj.Spark;
    import edu.wpi.first.wpilibj.Compressor;
    import edu.wpi.first.wpilibj.Solenoid;

public class Sweeper {
//set your pistons to default positions
    public static boolean fourBarS = false;
    public static boolean compressorT = false;
//name your motors, controller, and make the public static void drive here.
    public static Spark left = new Spark(0);
    public static Spark right = new Spark(1);
    public static Spark grab = new Spark(2);
    public static XboxController driver = new XboxController(3);
    public static Compressor compressor = new Compressor();
    public static Solenoid fourBarOpen = new Solenoid(0);
    public static Solenoid fourBarClose = new Solenoid(1);
    public static void drive(){
//set your speeds
    double speed = 0.5;
    double grabber = 0.2;
    //drivetrain
        left.set(-driver.getRawAxis(1) *speed);
        right.set(driver.getRawAxis(3)*speed);
        //graber on Sweeper
        if (driver.getRawButton(8)){
            grab.set(grabber);
        } else if (driver.getRawButton(7)); {
            grab.set(-grabber);
        }  {
            grab.set(0);
        }
        //piston controls
        if (driver.getRawButtonPressed(2)){
            if (compressorT) {
                compressor.start();
                compressorT = false;
            } else if (!compressorT) {
                compressor.stop();
                compressorT = true;
            }
        }
            if (driver.getRawButtonPressed(3)) {
                if (fourBarS) {
                    fourBarClose.startPulse();
                    fourBarS = false;
                } else if (!fourBarS) {
                    fourBarOpen.startPulse();
                    fourBarS = true;
                }
            }
        }
    }
