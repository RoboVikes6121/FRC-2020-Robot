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
      new resetAuton(m_gyro),  //resets encoders and gyro
      new limeLightAuton( m_drive, m_limeLight, 2), // lines up
      new shootAuton(m_shooter, m_intake), //shoots
      new turnAuton( m_drive, m_gyro, 180), //rotates 180 
      new resetAuton(m_gyro), 
      new moveAuton( m_drive, 100, .75), // moves forwered 100 in at 100% power
      new resetAuton(m_gyro),
      new pickupAuton( m_drive, m_intake, 100, .5), // drives forwered slowly with intake running
      new resetAuton(m_gyro),
      new moveAuton( m_drive, 200, -.75), // moves backwards at 100% power
      new resetAuton(m_gyro),
      new turnAuton( m_drive, m_gyro, -180),
      new resetAuton(m_gyro),
      new limeLightAuton( m_drive, m_limeLight, 2),
      new shootAuton(m_shooter, m_intake),
      new endAuton() // endes auton
    );
  }
}
