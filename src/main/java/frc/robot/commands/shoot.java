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
import frc.robot.subsystems.intake;
import frc.robot.subsystems.shooter;

public class shoot extends CommandBase {
  private shooter m_shooter;
  private intake m_Intake;

  public shoot(shooter shooter, intake intake) {
    m_shooter = shooter;
    m_Intake = intake;

    addRequirements(m_shooter);
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< HEAD
    if(RobotContainer.m_intake.INTAKESTATE == true) {
      RobotContainer.m_intake.intakeUpDown();
    }

=======
    double[] ENCODER_LIST = Robot.GetEncoder();
    if(ENCODER_LIST[6] >= Constants.SHOOTER_SPEED_VOL){
      if(RobotContainer.m_intake.INTAKESTATE == true) {
        RobotContainer.m_intake.intakeUpDown();
       }
    }
  
>>>>>>> 7c893a19b1241a9f10a91e8102214b9e7c3d0dd6
    boolean FLAG = RobotContainer.m_shooter.shootTwo();
    if(FLAG == true){
      RobotContainer.m_intake.intakeIn();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_intake.end();
    RobotContainer.m_shooter.end();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
