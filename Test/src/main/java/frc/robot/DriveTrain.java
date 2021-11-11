package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;


public class DriveTrain {

    
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static XboxController cont = new XboxController(3);

    public static void drive() {
        leftMotor.set(cont.getRawAxis(1));
        rightMotor.set(cont.getRawAxis(3));
        
    }
}

//import java.awt.event.*;

/*public static boolean F = false;
public static boolean D = false;
public static boolean L = false;
public static boolean R = false;

public void keyTyped(KeyEvent ke) {}
public void keyReleased(KeyEvent ke) {}

public void keyPressed(KeyEvent ke) {
if (ke.getKeyCode() == KeyEvent.VK_UP) {
    F = true;
}
else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
    D = true;
} 
else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {/*instruction for Left-key}
else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {/*instruction for Right-key}
}



public static void drive() {
    if (F == true) {
        leftMotor.set(1);
        rightMotor.set(1);
    }

    if (D == true) {
        leftMotor.set(-1);
        rightMotor.set(-1);
    }
*/