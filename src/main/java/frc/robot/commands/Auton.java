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

public class Auton extends CommandBase {
  double[] ENCODER_LIST;
  public static int TARGET_RIGHT;
  public static int TARGET_LEFT;
  public static double RIGHT_SPEED;
  public static double LEFT_SPEED;

  private driveTrain m_drive;
  public Auton(driveTrain drive, int RIGHT, int LEFT) {
    
    Robot.resetEncoder();
    ENCODER_LIST = Robot.GetEncoder();

    TARGET_LEFT = LEFT*22;
    TARGET_RIGHT = RIGHT*22;

    if(RIGHT == LEFT){
      RIGHT_SPEED = 1;
      LEFT_SPEED = 1;
    }else if(RIGHT > LEFT){
      LEFT_SPEED = 1;
      RIGHT_SPEED = LEFT/RIGHT;
    }else if(LEFT > RIGHT){
      RIGHT_SPEED = 1;
      LEFT_SPEED = RIGHT/LEFT;
    }

    System.out.println("SETUP");

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
    RobotContainer.m_driveTrain.autonDrive(RIGHT_SPEED, LEFT_SPEED);
    if(ENCODER_LIST[1] >= TARGET_LEFT){
      end(true);
    }
    if(ENCODER_LIST[4] >= TARGET_RIGHT){
      end(true);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.autonEnd();
    TARGET_LEFT = 0;
    TARGET_RIGHT = 0;
    RIGHT_SPEED = 0;
    LEFT_SPEED = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
