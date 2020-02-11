/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.gyro;

public class turnAuton extends CommandBase {
  private driveTrain m_driveTairn;
  private gyro m_gyro; 

  int Angle = 0;
  boolean forward;

  public turnAuton(driveTrain driveTrain, gyro gyro, int angle) {
   
    if(angle > 0){
      forward = true;
    }else{
      forward = false;
    }
    
    Angle = angle;

    m_gyro = gyro;
    addRequirements(m_gyro);

    m_driveTairn = driveTrain;
    addRequirements(m_driveTairn);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTairn.autonDriveTurn(forward);
    if(m_gyro.getAngle() >= Angle){
      end(true);
    }
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
