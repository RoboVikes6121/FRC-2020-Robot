/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX; //Today I learned that WPI_TalonSRX just extends TalonSRX and adds in the WPI functionality - Andrew 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  // Creates moter
  //motor?
  WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_1);
  WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.left_drive_moter_2);
  WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.right_drive_moter_1);
  WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.right_drive_moter_2);


  // Creates Differential Drive
  final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  
  public driveTrain() {
      //Sets the slave to follow master
      leftSlave.follow(leftMaster);
      rightSlave.follow(rightMaster);
  }

  public void manualDrive(double move, double turn){
    if(move > Constants.max_move_speed) move = Constants.max_move_speed;
    if(move < Constants.min_move_speed) move = Constants.min_move_speed;
    if(move > Constants.max_move_speed) move = Constants.max_move_speed;
    if(move < Constants.min_move_speed) move = Constants.min_move_speed;

    drive.arcadeDrive(move, turn);
  }

  @Override
  public void periodic() {
  
  }
}
