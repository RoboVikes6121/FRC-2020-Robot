/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  WPI_VictorSPX intakeMotor = new WPI_VictorSPX(Constants.INTAKE_MOTOR);
  
  public void intakeIN() {
   intakeMotor.set(ControlMode.PercentOutput, Constants.INTAKE_MOTOR);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
