package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.driveTrain;;

public class driveManual extends CommandBase {

  //Note that this uses an object with keywords 'private' and 'final' to create a driveTrain object named m_drive
   private final driveTrain m_drive;
  //
  
  //you are creating a local variable named drive which is the same as the driveTrain object from the subsystem. This drive variable is confined to this class though.
  public driveManual(driveTrain drive) {
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
    //getting x and y for sticks
    double MOVE = Robot.m_robotContainer.GetDriveRawAxis(Constants.LEFT_STICK_Y);
    double TURN = Robot.m_robotContainer.GetDriveRawAxis(Constants.RIGHT_STICK_X);
    boolean PRECISION_BUTTON_IS_PRESSED = Robot.m_robotContainer.GetRawButton(Constants.PRECISION_BUTTON);
    //calling drive 
    RobotContainer. m_drive.manualDrive((MOVE*-1), TURN, PRECISION_BUTTON_IS_PRESSED);
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
