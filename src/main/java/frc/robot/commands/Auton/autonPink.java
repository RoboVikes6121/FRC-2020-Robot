/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.gyro;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class autonPink extends SequentialCommandGroup {

  public autonPink(driveTrain  m_drive, LimeLight m_limeLight, gyro m_gyro, shooter m_shooter, intake m_intake) {
    System.out.println("ONE");
    addCommands(
      new moveAuton(m_drive, 70, .5),
      new shootAuton(m_shooter, m_intake) //shoot
    );
  }
}
