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

  private final double kP = .0008;
  private final double kI = 0;
  private final double kD = 0;

  public shooter() {
    MASTER.setNeutralMode(NeutralMode.Coast);

    MASTER.configFactoryDefault();

    MASTER.setInverted(false);

    MASTER.setSensorPhase(false);
  }

  double sumError = 0;
  double priError = 0;
  double deri = 0;

  double max = 0;

  public boolean shootTwo(){
    
    double[] ENCODER_LIST = Robot.GetEncoder();
    double error = Constants.SHOOTER_SPEED_VOL - ENCODER_LIST[6];
    
    if(ENCODER_LIST[6] > max){
      max = ENCODER_LIST[6];
    }

    System.out.println("ERROR " + max);

    if(error > 100){
      MASTER.set(ControlMode.PercentOutput, .35);
      return false;
    }else{
      MASTER.set(ControlMode.PercentOutput, .35);
      return true;
    }

    

    //MASTER.set(ControlMode.PercentOutput, .30);
    //return false;
  } 


  int count = 0;
  public boolean shootAuton() {
     if(count >= 450){
       count = 0;
      return true;
     }else{
      count++;
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