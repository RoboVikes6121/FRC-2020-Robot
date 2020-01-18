/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class wof extends SubsystemBase {
  public static VictorSPX WOF = new VictorSPX(Constants.WOF_MOTOR);

  public int counter = 0;
  public int flag = 0;

  public wof() {
     
  }

  public void spin(){
    char INPUT = Robot.gameData();
    String COLOR_ONE = Robot.getColorString(Robot.getColor());
    char COLOR = Robot.getColorString(Robot.getColor()).charAt(0);
    counter = 0;
    flag = 0;

    if(INPUT == 'n'){
      WOF.set(ControlMode.PercentOutput, Constants.WOF_SPEED);

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
      WOF.set(ControlMode.PercentOutput, Constants.WOF_SPEED);
      if(COLOR == INPUT){
        WOF.set(ControlMode.PercentOutput, 0);
      }
    }
  }

  public void end() {
    WOF.set(ControlMode.PercentOutput, Constants.WOF_SPEED);
    counter = 0;
    flag = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
