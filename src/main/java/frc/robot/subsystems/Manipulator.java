// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Manipulator extends SubsystemBase {
  private final static CANSparkMax arm1 = new CANSparkMax(Constants.MotorControllerPorts.kArm1, MotorType.kBrushless);
  private final static CANSparkMax arm2 = new CANSparkMax(Constants.MotorControllerPorts.kArm2, MotorType.kBrushless);
  private final static CANSparkMax manipulator = new CANSparkMax(Constants.MotorControllerPorts.kManipulator, MotorType.kBrushless);

  /** Creates a new Manipulator. */
  public Manipulator() {
    arm1.setIdleMode(IdleMode.kBrake);
    arm2.setIdleMode(IdleMode.kBrake);

    arm2.follow(arm1);
  }

  public void setArm(double speed) {
    System.out.println(speed);
    arm1.set(speed);
  }

  public void setManipulator(double speed) {
    manipulator.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(arm1.getEncoder().getPosition());
  }
}
