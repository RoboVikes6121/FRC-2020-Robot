/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.LimeLight;;

public class limeLigntDrive extends CommandBase {
  private final driveTrain m_DriveTrain;
  private final LimeLight m_LimeLight;

  // Constants: tune driving and steering control constants
  private double m_steeringKP = 0.03;
  private double m_targetArea = 3;
  private double m_driveKP = 0.26;

  /**
   * Creates a new AlignWithVision.
   */
  public limeLigntDrive(driveTrain driveTrain, LimeLight limeLight) {
    m_DriveTrain = driveTrain;
    m_LimeLight = limeLight;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_DriveTrain, m_LimeLight);

    SmartDashboard.putNumber("Steering KP", .05);
    SmartDashboard.putNumber("min TA", 3);
    SmartDashboard.putNumber("Driving KP", 0.26);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_steeringKP = SmartDashboard.getNumber("Steering KP", 0.0);
    m_targetArea = SmartDashboard.getNumber("min TA", 0.0);
    m_driveKP = SmartDashboard.getNumber("Driving KP", 0.0);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   double MOVE = m_LimeLight.getTX()*m_steeringKP; // Right Y
   double TURN  = (m_targetArea-m_LimeLight.getTA())*m_driveKP; // Left X
    SmartDashboard.putNumber("target area", m_targetArea);

    if (m_LimeLight.isTargetValid()) {
      
      m_DriveTrain.manualDrive(MOVE, TURN, false); // Drive until the target is at desired distance
    } else {
      m_DriveTrain.manualDrive(0, 0, false);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.manualDrive(0, 0, interrupted); // set left and right values to 0
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // don't return true ever, command will end after button is released
    return false;
  }
}