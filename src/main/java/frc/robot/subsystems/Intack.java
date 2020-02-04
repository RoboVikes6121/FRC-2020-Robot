/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intack extends SubsystemBase {
  VictorSPX MASTER = new VictorSPX(Constants.INTAKE_MOTOR);
  DoubleSolenoid MAIN = new DoubleSolenoid(Constants.INTAKE_OUT_SOUL, Constants.INTAKE_IN_SOUL);

  boolean IntackState = true;

  public void intack(){
    MASTER.set(ControlMode.PercentOutput, Constants.INTAKE_SPEED);
  }

  public void intackUpDown(){
    if(IntackState == true){
      MAIN.set(DoubleSolenoid.Value.kForward);
    }else{
      MAIN.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void end(){
    MASTER.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
