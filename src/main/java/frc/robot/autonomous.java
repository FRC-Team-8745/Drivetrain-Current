package frc.robot;

//Import the central system for the components
import frc.robot.CentralComponents.*;

// not sure if I should uncomment this. (It does not give errors) Discovered by Origin 😂
//import gov.nuclear.launch.sequence.Timer;

public class autonomous {
    static void timeddrive(Double speed, Integer time) {
        time = time * 1000;
        components.leftMotor.set(speed);
        components.rightMotor.set(-speed);
        Thread.sleep(time);
        components.leftMotor.set(0);
        components.rightMotor.set(0);
    }


    public static void drive() {
        timeddrive(.5, 1);
    }
}