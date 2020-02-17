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
  public static TalonFX MASTER = new TalonFX(Constants.SHOOTER_MOTOR); // encoders 6,7

  private final double kP = 0.15;
  private final double kI = 0.0;
  private final double kD = 1.0;
  private final double kF = 0.0;
  private final int kTimeoutMs = 30;

  public shooter() {
    MASTER.setNeutralMode(NeutralMode.Brake);

    MASTER.configFactoryDefault();

    MASTER.setInverted(false);

    MASTER.setSensorPhase(false);

    //MASTER.config_kP(1, kP, kTimeoutMs);
    //MASTER.config_kI(0, kI, kTimeoutMs);
    //MASTER.config_kD(0, kD, kTimeoutMs);
    //MASTER.config_kF(0, kF, kTimeoutMs);
  }

  double sumError = 0;
  double priError = 0;
  double deri = 0;

  public boolean shoot() {
    double[] ENCODER_LIST = Robot.GetEncoder();

    double error = Constants.SHOOTER_SPEED_VOL - ENCODER_LIST[6];
    sumError += error / .02;
    deri = (error - priError) / .02;
    double OUTPUT = (kP * error) + (kI * sumError) + (kD * deri);

    MASTER.set(ControlMode.PercentOutput, OUTPUT);
    priError = error;

    if (ENCODER_LIST[6] >= Constants.SHOOTER_SPEED_VOL) {
      return true;
    } else {
      return false;
    }
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