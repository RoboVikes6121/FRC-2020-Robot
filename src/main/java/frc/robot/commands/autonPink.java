/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.gyro;
import frc.robot.subsystems.shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class autonPink extends SequentialCommandGroup {

  public autonPink(driveTrain m_driveTrain, LimeLight m_limeLight, gyro m_gyro, shooter m_shooter) {
    System.out.println("ONE");
    addCommands(
      //new limeLightAuton(m_driveTrain, m_limeLight),
      new turnAuton(m_driveTrain, m_gyro, 180), 
      new moveAuton(m_driveTrain, 70),
      new moveAuton(m_driveTrain, -70),
      new turnAuton(m_driveTrain, m_gyro, -170)
    );
  }
}
