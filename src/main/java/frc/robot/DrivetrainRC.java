package frc.robot;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;

public class DrivetrainRC{
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Joystick cont = new Joystick(0);
    public static void driverun(){
    
        rightMotor.set(cont.getRawAxis(1)*0.5);
        leftMotor.set(-cont.getRawAxis(1)*0.5);
        if(cont.getRawAxis(0)>0){
            rightMotor.set(cont.getRawAxis(0)*0.5);
        }
        if(cont.getRawAxis(0)<0){
            leftMotor.set(cont.getRawAxis(0)*0.5);
        }
    }        
}