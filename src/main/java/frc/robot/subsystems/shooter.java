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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class shooter extends SubsystemBase {
  public static TalonFX MASTER = new TalonFX(Constants.SHOOTER_MOTOR); // encoders 6,7

  public shooter() {
    MASTER.setNeutralMode(NeutralMode.Coast);

    MASTER.configFactoryDefault();

    MASTER.setInverted(false);

    MASTER.setSensorPhase(false);
  }


  double max = 0;

  public boolean shoot(boolean high){
    double[] ENCODER_LIST = Robot.GetEncoder();
    double error = Constants.LOW_SHOOTER_SPEED_VOL - ENCODER_LIST[6];
    
    if(high == false){
      MASTER.set(ControlMode.PercentOutput, Constants.LOW_SHOOTER_SPEED);
    }else{
      //MASTER.set(ControlMode.PercentOutput, .20);
    }

    System.out.println(ENCODER_LIST[6]);
    
    if(error > 100){
      return false;
    }else{
      return true;
    }
  } 
  public void shootback(){
    MASTER.set(ControlMode.PercentOutput, -.20);
  } 

  public void end(){
    MASTER.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}