/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Index extends SubsystemBase {
 WPI_TalonSRX indexMotor = new WPI_TalonSRX(Constants.INDEX_MOTOR);

  public void indexIn() {
    indexMotor.set(ControlMode.PercentOutput, Constants.INDEX_SPEED);
  }
  public void indexOut(){
    indexMotor.set(ControlMode.PercentOutput, -Constants.INDEX_SPEED);
  }
  public void end(){
    indexMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
