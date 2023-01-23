// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;

public class ClawPistonRetract extends CommandBase {
  private final Intake manipulatorSubsystem;

  /** Creates a new ArmCommand. */
  public ClawPistonRetract(Intake subsystem) {
    manipulatorSubsystem = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(manipulatorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    manipulatorSubsystem.setClaw(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
