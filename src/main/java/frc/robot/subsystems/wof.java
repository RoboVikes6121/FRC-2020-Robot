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
import frc.robot.Robot;

public class wof extends SubsystemBase {
  public static VictorSPX MASTER = new VictorSPX(Constants.WOF_MOTOR);
  DoubleSolenoid UPDOWN = new DoubleSolenoid(Constants.WOF_IN_SOUL, Constants.WOF_OUT_SOUL);

  public int counter = 0;
  public int flag = 0;

  boolean WOFSTATE = false; 

  public void spin(){
    char INPUT =  Robot.gameData();
    String COLOR_ONE = Robot.getColorString(Robot.getColor());
    char COLOR = Robot.getColorString(Robot.getColor()).charAt(0);
    counter = 0;
    flag = 0;

    if(INPUT == 'n'){
      MASTER.set(ControlMode.PercentOutput, Constants.WOF_SPEED);
      if(flag == 0){
        if (Robot.getColorString(Robot.getColor()) != COLOR_ONE) flag = 1;
      }else if(flag == 1){
        if(Robot.getColorString(Robot.getColor()) == COLOR_ONE){
          counter++;
          flag = 0;
        } 
      }

      if(counter <= 8){
        end();
      }

    }else{
      MASTER.set(ControlMode.PercentOutput, Constants.WOF_SPEED);
      if(COLOR == INPUT){
        MASTER.set(ControlMode.PercentOutput, 0);
      }
    }
  }

  int time = 0;
  public boolean manualSpin(){
    MASTER.set(ControlMode.PercentOutput, Constants.WOF_SPEED);

    if(time == 850){
      time = 0;
      return true;
    }else{
      time++;
      return false;
    }
  }

  public void upDown(){
    System.out.println(WOFSTATE);
    if(WOFSTATE == false){
      UPDOWN.set(DoubleSolenoid.Value.kForward);
      WOFSTATE = true;
    }else{
      UPDOWN.set(DoubleSolenoid.Value.kReverse);
      WOFSTATE = false;
    }
  }

  public void end() {
    MASTER.set(ControlMode.PercentOutput, 0);
    counter = 0;
    flag = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
