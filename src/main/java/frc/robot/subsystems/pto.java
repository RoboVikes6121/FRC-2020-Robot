/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class pto extends SubsystemBase {
  
  public static WPI_TalonSRX SHOOTER_MASTER = new WPI_TalonSRX(Constants.MASTER_PTO_MOTOR); 
  WPI_TalonSRX SHOOTER_SLAVE = new WPI_TalonSRX(Constants.SLAVE_PTO_MOTOR);
  public static WPI_VictorSPX INDEX = new WPI_VictorSPX(Constants.INDEX_MOTOR);

  public static int INITL = 0;

  public pto() {
    SHOOTER_SLAVE.follow(SHOOTER_MASTER);
  }

  public void shot(){

    INDEX.set(ControlMode.PercentOutput, Constants.INDEX_SPEED);
    //double[] ENCODER_LIST = Robot.GetEncoder();
    
    /*
    if(INITL == 0){ 
      SHOOTER_MASTER.set(ControlMode.PercentOutput, -Constants.SHOOTER_SPEED);
      Timer.delay(.5);
      INITL++;
    }else if(ENCODER_LIST[1] >= Constants.HIGH_GOAL_SPEED){
      SHOOTER_MASTER.set(ControlMode.PercentOutput, Constants.SHOOTER_SPEED);
      INDEX.set(ControlMode.PercentOutput, Constants.INDEX_SPEED);
    }
    else{
      SHOOTER_MASTER.set(ControlMode.PercentOutput, Constants.SHOOTER_SPEED);
    }
    */
  }

  public void climb(){
    
  }

  public static void end(){
    INDEX.set(ControlMode.PercentOutput, 0);
    SHOOTER_MASTER.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
