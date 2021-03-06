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
import frc.robot.Constants;
import frc.robot.subsystems.LimeLight;;

public class limeLightDrive extends CommandBase {
  private final driveTrain  m_drive;
  private final LimeLight m_LimeLight;

  // Constants: tune driving and steering control constants
  private double m_steeringKP = Constants.STREEING_KP;
  private double m_targetArea = Constants.MIN_TARGET_AREA;
  private double m_driveKP = Constants.DRIVER_KP;

  /**
   * Creates a new AlignWithVision.
   */
  public limeLightDrive(driveTrain driveTrain, LimeLight limeLight) {
     m_drive = driveTrain;
    m_LimeLight = limeLight;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( m_drive, m_LimeLight);

    SmartDashboard.putNumber("Steering KP", Constants.STREEING_KP);
    SmartDashboard.putNumber("min TA", Constants.MIN_TARGET_AREA);
    SmartDashboard.putNumber("Driving KP", Constants.DRIVER_KP);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_LimeLight.enable();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   double TURN = m_LimeLight.getTX()*m_steeringKP; // Right Y
   double MOVE  = (m_targetArea-m_LimeLight.getTA())*m_driveKP; // Left X
    SmartDashboard.putNumber("target area", m_targetArea);

    m_targetArea = SmartDashboard.getNumber("min TA", 0.0);
    m_driveKP = SmartDashboard.getNumber("Driving KP", 0.0);
    m_steeringKP = SmartDashboard.getNumber("Steering KP", 0.0);
    
    

    if (!m_LimeLight.isTargetValid()) {
       m_drive.limeLightDrive(MOVE, -TURN); // Drive until the target is at desired distance
    } else {
       m_drive.limeLightDrive(0, 0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_LimeLight.disable();
     m_drive.limeLightDrive(0, 0); // set left and right values to 0
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // don't return true ever, command will end after button is released
    
    return false;
  }
}