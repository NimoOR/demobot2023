// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//imported modules needed
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private final static CANSparkMax arm1 = new CANSparkMax(Constants.MotorControllerPorts.kArm1, MotorType.kBrushless);
  private final static CANSparkMax arm2 = new CANSparkMax(Constants.MotorControllerPorts.kArm2, MotorType.kBrushless);
  
  /** Creates a new Manipulator. */
  public Arm() {
    arm1.setIdleMode(IdleMode.kBrake);
    arm2.setIdleMode(IdleMode.kBrake);

    arm1.getPIDController().setP(Constants.armkP);
    arm2.getPIDController().setP(Constants.armkP);

    arm2.follow(arm1);
  }

  public void setArm(double speed) {
    arm1.set(speed);
    System.out.println(arm1.getEncoder().getPosition());
  }

  public void resetArmPos() {
    arm1.getEncoder().setPosition(0);
  }

  public void setArmPos(double pos) {
    arm1.getPIDController().setReference(pos, ControlType.kPosition);
    arm2.getPIDController().setReference(pos, ControlType.kPosition);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
