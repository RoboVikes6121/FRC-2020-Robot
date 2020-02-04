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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class pto extends SubsystemBase {
  public static TalonFX MASTER = new TalonFX(Constants.MASTER_PTO_MOTOR); // encoders 4,5
  TalonFX SLAVE = new TalonFX(Constants.SLAVE_PTO_MOTOR);
  Solenoid MAIN = new Solenoid(Constants.PTO_SOUL);

  boolean CRESETFLAG = false;
  boolean ERESETFLAG = false;

  public pto() {
    MASTER.setNeutralMode(NeutralMode.Brake);
    SLAVE.setNeutralMode(NeutralMode.Brake);

    MASTER.configFactoryDefault();

    MASTER.setInverted(false);

    MASTER.setSensorPhase(false);
    
    SLAVE.follow(MASTER);
  }

  public void climb() {
    if(CRESETFLAG == false){
      Robot.resetEncoder();
    }
    MAIN.set(true);

    double[] ENCODER_LIST = Robot.GetEncoder();

    if(ENCODER_LIST[5] <= Constants.CLIMB_POS){
      MASTER.set(ControlMode.PercentOutput, Constants.CLIMB_SPEED);
    }else{
      MASTER.set(ControlMode.PercentOutput, 0);
    }

  }

  public void elvUp(){
    if(ERESETFLAG == false){
      Robot.resetEncoder();
    }
    MAIN.set(false);

    double[] ENCODER_LIST = Robot.GetEncoder();

    if(ENCODER_LIST[5] <= Constants.ELIVATOR_POS){
      MASTER.set(ControlMode.PercentOutput, Constants.ELIVATOR_SPEED);
    }else{
      MASTER.set(ControlMode.PercentOutput, 0);
    }
  }

  public void elvDown(){
    double[] ENCODER_LIST = Robot.GetEncoder();
    
    if(ENCODER_LIST[5] >= 0){
      MASTER.set(ControlMode.PercentOutput, Constants.ELIVATOR_SPEED);
    }else{
      MASTER.set(ControlMode.PercentOutput, 0);
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
