// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.CentralComponents.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  @Override
  public void robotInit() {
    Components.init();
    //ComponentsSweeper.init();
    Components.gyro.calibrate();
    Components.gyro.reset();
  }

  @Override
  public void robotPeriodic() {
    shuffleboard.displayContent();
  }

  @Override
  public void autonomousInit() {
    Components.gyro.reset();
    Components.gyro.calibrate();
  }

  @Override
  public void autonomousPeriodic() {
    PIDgyro.gyroDrive();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    //Sweeper.drive();
    DrivetrainJoystick.drive();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
    Components.init();
  }

  @Override
  public void testPeriodic() {
    shuffleboard.displayContent();
  }
}
