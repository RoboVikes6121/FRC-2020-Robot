/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.shooter;

public class shootAuton extends CommandBase {
  
  public shooter m_shooter;
  public intake m_intake;

  double count = 0;
  boolean isDone;

  public shootAuton(shooter shooter, intake intake) {

    m_shooter = shooter;
    addRequirements(m_shooter);

    m_intake = intake;
    addRequirements(m_intake);

    count = 0;
    isDone = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean check = m_shooter.shoot(true);
    if(check == true){

      if(m_intake.INTAKESTATE == true) {
        m_intake.intakeUpDown();
       }
      count++;
      m_intake.intakeIn();
    }
    if(count >= 200){
      isDone = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.end();
    m_shooter.end();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
