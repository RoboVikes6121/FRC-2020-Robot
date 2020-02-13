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

public class limeLightAuton extends CommandBase {
  private final driveTrain m_DriveTrain;
  private final LimeLight m_LimeLight;

  // Constants: tune driving and steering control constants
  private double m_steeringKP = Constants.STREEING_KP;
  private double m_targetArea = Constants.MIN_TARGET_AREA;
  private double m_driveKP = Constants.DRIVER_KP;

  public boolean FLAG;
  public int FLAGCOUNT;

  /**
   * Creates a new AlignWithVision.
   */
  public limeLightAuton(driveTrain driveTrain, LimeLight limeLight) {
    m_DriveTrain = driveTrain;
    m_LimeLight = limeLight;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_DriveTrain, m_LimeLight);

    SmartDashboard.putNumber("Steering KP", Constants.STREEING_KP);
    SmartDashboard.putNumber("min TA", Constants.MIN_TARGET_AREA);
    SmartDashboard.putNumber("Driving KP", Constants.DRIVER_KP);

    FLAG = false;
    FLAGCOUNT = 0;
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
<<<<<<< HEAD
      m_DriveTrain.limeLightDrive(MOVE, TURN*-1); // Drive until the target is at desired distance
=======
      m_DriveTrain.limeLightDrive(MOVE, TURN); // Drive until the target is at desired distance
>>>>>>> 7cc794b7f845e917afb5bf7fe0cf411b4c316a22
    } else {
      m_DriveTrain.limeLightDrive(0, 0);
      FLAGCOUNT++;
    }

    if(FLAGCOUNT == Constants.FLAG_COUNT_MAX){
      FLAG = true;
    }
    SmartDashboard.putBoolean("FLAG", FLAG);
    
    if(FLAG == true){
      end(true);
      System.out.println("ITS DONE YOU MORON");
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // m_LimeLight.disable();
    m_DriveTrain.limeLightDrive(0, 0); // set left and right values to 0
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // don't return true ever, command will end after button is released
    
    return false;
  }
}