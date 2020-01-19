/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;

public class limeLigntDrive extends CommandBase {
  private final driveTrain m_drive;
  private final LimeLight m_LimeLight;
  /**
   * Creates a new limeLigntDrive.
   */
  public limeLigntDrive(driveTrain drive, LimeLight m_LimeLight) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_driveTrain.limeLightDrive(m_LimeLightDriveCommand, m_LimeLightSteerCommand);
    // m_drive.limeLightDrive(m_LimeLightDriveCommand, m_LimeLightSteerCommand);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
