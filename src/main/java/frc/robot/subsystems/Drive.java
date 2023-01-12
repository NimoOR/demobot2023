// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drive extends SubsystemBase {
  private static Joystick joystick;

  private final static Spark leftmotors1 = new Spark(1);
  private final static Spark leftmotors2 = new Spark(2);
  private final static Spark rightmotors1 = new Spark(3);
  private final static Spark rightmotors2 = new Spark(4);
  public Drive(Joystick stick) {
    
    joystick = stick;
  
  }
  
  public void setPower(double leftPower, double rightPower){
    leftmotors1.set(leftPower);
    leftmotors2.set(leftPower);

    rightmotors1.set(rightPower);
    rightmotors2.set(rightPower);
  }

  @Override
  public void periodic() {
    setPower(joystick.getRawAxis(5),joystick.getRawAxis(1));
  }

}
