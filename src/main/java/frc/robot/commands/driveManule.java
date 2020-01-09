/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.driveTrain;;


//Manual? Manule?
public class driveManule extends CommandBase {
  /**
   * Creates a new driveManule.
   */

  //Note that this uses an object with keywords 'private' and 'final' to create a driveTrain object named m_drive
  //This is generally considered good practice, as it keeps this object safe from outside code interfering in malicious ways.
  //
   private final driveTrain m_drive;
  //
  
  //you are creating a local variable named drive which is the same as the driveTrain object from the subsystem. This drive variable is confined to this class though.
  public driveManule(driveTrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    //Then use the final m_drive object and set it equal to drive
    m_drive = drive;
    //Lastly, use 'addRequirements() with the m_drive object to make the requirement.'
    addRequirements(m_drive);
    //This is all because good practice dictates it is done this way. Theoretically it could be done as
    // addRequirements(drive);
    //but that would be bad practice.
    //so don't do it like that.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = Robot.m_robotContainer.GetDriveRawAxis(Constants.LEFT_STICK_X);
    double turn = Robot.m_robotContainer.GetDriveRawAxis(Constants.LEFT_STICK_Y);
    RobotContainer.m_driveTrain.manualDrive(move, turn);
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
