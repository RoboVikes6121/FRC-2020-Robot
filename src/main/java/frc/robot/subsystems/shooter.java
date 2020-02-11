/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class shooter extends SubsystemBase {
  public static TalonFX MASTER = new TalonFX(Constants.SHOOTER_MOTOR);  // encoders 6,7

  double P = 1;
  double I = 1;
  double D = 1;

  public shooter() {
    MASTER.setNeutralMode(NeutralMode.Brake);
    
    MASTER.configFactoryDefault();

    MASTER.setInverted(false);

    MASTER.setSensorPhase(false);
  }

  double sumError = 0;
  double priError = 0;
  double deri = 0;

  public boolean shoot(){
    double[] ENCODER_LIST = Robot.GetEncoder();

    double error = Constants.SHOOTER_SPEED_VOL - ENCODER_LIST[6];
    sumError += error/.02;
    deri = (error-priError)/.02;
    double OUTPUT = (P*error) + (I*sumError) + (D*deri);

    MASTER.set(ControlMode.PercentOutput, OUTPUT);
    priError = error;

    MASTER.set(ControlMode.PercentOutput, Constants.SHOOTER_SPEED);

    if(ENCODER_LIST[6] >= Constants.SHOOTER_SPEED_VOL){
      return true;
    }else{
      return false;
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
