/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.driveTrain;

public class moveAuton extends CommandBase {
  double[] ENCODER_LIST;
  double MOVE;
  boolean forword;

  boolean isDone;

  private driveTrain m_drive;

  public moveAuton(driveTrain drive, int move) {
   System.out.println("STARTING MOVING");
    isDone = false;

    Robot.resetEncoder();
    ENCODER_LIST = Robot.GetEncoder();

    MOVE = move*90;
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
    driveTrain.autonDrive(forword);
    if(Math.abs(ENCODER_LIST[1]) >= MOVE  ||  Math.abs(ENCODER_LIST[3]) >= MOVE){
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.autonEnd();
    System.out.println("YOU ARE DONE DUMB DUMB");
    Robot.resetEncoder();
    isDone = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
