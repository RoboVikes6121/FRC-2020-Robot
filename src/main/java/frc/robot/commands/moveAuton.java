/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.driveTrain;

public class moveAuton extends CommandBase {
  double[] ENCODER_LIST;
  double MOVE;
  boolean forword;


  private driveTrain m_drive;
  public moveAuton(driveTrain drive, int move) {
    
    Robot.resetEncoder();
    ENCODER_LIST = Robot.GetEncoder();

    MOVE = move*22;
    if(MOVE > 0){
      forword = false;
    }else{
      forword = true;
    }

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
    ENCODER_LIST = Robot.GetEncoder();
    RobotContainer.m_driveTrain.autonDrive(forword);
    if(ENCODER_LIST[1] >= MOVE  ||  ENCODER_LIST[4] >= MOVE){
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.autonEnd();
    MOVE = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
