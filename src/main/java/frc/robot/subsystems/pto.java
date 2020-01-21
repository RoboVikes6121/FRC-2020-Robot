/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class pto extends SubsystemBase {
  
  public static WPI_TalonFX MASTER = new WPI_TalonFX(Constants.MASTER_PTO_MOTOR); 
  WPI_TalonFX SLAVE = new WPI_TalonFX(Constants.SLAVE_PTO_MOTOR);
  public static WPI_VictorSPX INDEX = new WPI_VictorSPX(Constants.INDEX_MOTOR);
  Solenoid PTO_SOUL = new Solenoid(Constants.PTO_SOUL);

  public static int INITL = 0;

  public pto() {
    SLAVE.follow(MASTER);
  }

  public void shoot(){

    INDEX.set(ControlMode.PercentOutput, Constants.INDEX_SPEED);
    Robot.resetEncoder();
    double[] ENCODER_LIST = Robot.GetEncoder();

    /*if(INITL == 0){ 
      while(ENCODER_LIST[8] >= 5){
        INDEX.set(ControlMode.PercentOutput, -Constants.INDEX_SPEED);
      }
      INITL++;
    }else if(ENCODER_LIST[1] >= Constants.HIGH_GOAL_SPEED){
      MASTER.set(ControlMode.PercentOutput, Constants.SHOOTER_SPEED);
      INDEX.set(ControlMode.PercentOutput, Constants.INDEX_SPEED);
    }
    else{
      MASTER.set(ControlMode.PercentOutput, Constants.SHOOTER_SPEED);
    }*/
  }

  public void climb(){
    MASTER.set(ControlMode.PercentOutput, Constants.CLIMB_SPEED);
  }

  public void switchPTO(){
    if(PTO_SOUL.get() == true){
      PTO_SOUL.set(false);
    }else{
      PTO_SOUL.set(true);
    }
  }

  public static void end(){
    INITL = 0;
    INDEX.set(ControlMode.PercentOutput, 0);
    MASTER.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
