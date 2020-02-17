/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.gyro;

public class turnAuton extends CommandBase {
  private driveTrain m_driveTairn;
  private gyro m_gyro; 

  int Angle = 0;

  boolean isDone;

  public turnAuton(driveTrain driveTrain, gyro gyro, int angle) {
    isDone = false;
    
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
    boolean check = m_driveTairn.autonDriveTurn(Angle);
  
    if(check == true){
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTairn.autonEnd();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
