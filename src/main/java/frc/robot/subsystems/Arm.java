// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private final static CANSparkMax arm1 = new CANSparkMax(Constants.MotorControllerPorts.kArm1, MotorType.kBrushless);
  private final static CANSparkMax arm2 = new CANSparkMax(Constants.MotorControllerPorts.kArm2, MotorType.kBrushless);
  
  /** Creates a new Manipulator. */
  public Arm() {
    arm1.setIdleMode(IdleMode.kBrake);
    arm2.setIdleMode(IdleMode.kBrake);

    arm2.follow(arm1);
  }

  public void setArm(double speed) {
    arm1.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
