// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private final static CANSparkMax intake = new CANSparkMax(Constants.MotorControllerPorts.kManipulator, MotorType.kBrushless);
  private final static DigitalInput ManipulatorSwitch = new DigitalInput(Constants.MotorControllerPorts.intakeLimitPort);
  private final static Solenoid claw1 = new Solenoid(PneumaticsModuleType.REVPH, Constants.MotorControllerPorts.kClaw1Solenoid);
  private final static Solenoid claw2 = new Solenoid(PneumaticsModuleType.REVPH, Constants.MotorControllerPorts.kClaw2Solenoid);

  /** Creates a new Manipulator. */
  public Intake() {
    intake.setIdleMode(IdleMode.kBrake);
  }

  public void setIntake(double speed) {
      intake.set(speed); 
  }

  public void setClaw(){
    claw1.set(!claw1.get());
    claw2.set(!claw2.get());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // System.out.println(ManipulatorSwitch.get());
  }
  
  public boolean cancelIfLimitTriggered() {
    if(!ManipulatorSwitch.get()){
      intake.set(0);
      return true;
    }
    return false;
  }
}
