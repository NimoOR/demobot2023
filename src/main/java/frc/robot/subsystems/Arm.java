// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private final static CANSparkMax arm1 = new CANSparkMax(Constants.MotorControllerPorts.kArm1, MotorType.kBrushless);
  private final static CANSparkMax arm2 = new CANSparkMax(Constants.MotorControllerPorts.kArm2, MotorType.kBrushless);
  
  private final static DutyCycleEncoder enc = new DutyCycleEncoder(5);
  
  private double proportional = 0.0;
  private double voltage = 0.0;
  private double integral = 0.0;
  private double derivative = 0.0;
  private double oldError = 0.0;

  
  /** Creates a new Manipulator. */
  public Arm() {
    arm1.setIdleMode(IdleMode.kBrake);
    arm2.setIdleMode(IdleMode.kBrake);

    arm2.follow(arm1);
  }

  public void setArm(double speed) {
    arm1.set(speed);
  }

  public double PID(double setPoint) {
    System.out.println(setPoint + ", " + enc.getAbsolutePosition() + ", " + (setPoint - enc.getAbsolutePosition()));

    double error = setPoint - enc.getAbsolutePosition();
    proportional = error * Constants.PIDConstants.kArmP;
    integral += error * Constants.PIDConstants.kArmI * Constants.PIDConstants.cycleTime;
    derivative = Constants.PIDConstants.kArmD * (error - oldError) / Constants.PIDConstants.cycleTime;

    voltage += proportional + integral + derivative;

    oldError = error;

    if(voltage < -3.0) {
      voltage = -3.0;
    } else if (voltage > 0) {
      voltage = 0;
    }

    System.out.println(error + ", " + voltage + ", " + proportional);

    return voltage;
  }

  public void setArmPos(double pos) {
    arm1.setVoltage(PID(pos));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    System.out.println(enc.getAbsolutePosition());
  }
}
