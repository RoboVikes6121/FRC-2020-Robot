package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX; //Today I learned that WPI_TalonSRX just extends TalonSRX and adds in the WPI functionality - Andrew 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.driveManual;
import frc.robot.Robot;

public class driveTrain extends SubsystemBase {

  public static WPI_TalonSRX LEFTMASTER = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_1);
  WPI_TalonSRX LEFTSLAVE = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_2);
  public static WPI_TalonSRX RIGHTMASTER = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_1);
  WPI_TalonSRX RIGHTSLAVE = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_2);


  // Creates Differential Drive
  final DifferentialDrive drive = new DifferentialDrive(LEFTMASTER, RIGHTMASTER);
  
  public driveTrain() {
      //Sets the slave to follow master
      LEFTSLAVE.follow(LEFTMASTER);
      RIGHTSLAVE.follow(RIGHTMASTER);
  }

  public void manualDrive(double MOVE, double TURN, boolean PRECISION_BUTTON_IS_PRESSED){
    // setting min and max speed
    if(PRECISION_BUTTON_IS_PRESSED == true){ // setting speeds when the button is pressed
      if(MOVE > Constants.PRECISION_MAX_MOVE_SPEED) MOVE = Constants.PRECISION_MAX_MOVE_SPEED;
      if(MOVE < Constants.PRECISION_MIN_MOVE_SPEED) MOVE = Constants.PRECISION_MIN_MOVE_SPEED;
      if(TURN > Constants.PRECISION_MAX_MOVE_SPEED) TURN = Constants.PRECISION_MAX_MOVE_SPEED;
      if(TURN < Constants.PRECISION_MIN_MOVE_SPEED) TURN = Constants.PRECISION_MIN_MOVE_SPEED;
    }else{ // setting speeds when the button is not pushed   
      if(MOVE > Constants.MAX_MOVE_SPEED) MOVE = Constants.MAX_MOVE_SPEED;
      if(MOVE < Constants.MIN_MOVE_SPEED) MOVE = Constants.MIN_MOVE_SPEED;
      if(TURN > Constants.MAX_MOVE_SPEED) TURN = Constants.MAX_MOVE_SPEED;
      if(TURN < Constants.MIN_MOVE_SPEED) TURN = Constants.MIN_MOVE_SPEED;
      //this is code it implent tyhe encoders into the drive train but i  have it comentted till we test getting information from the encoders 
      /*if(TURN == 0){ //implemting the encoders into the drive train 
        double[] ENCODER_LIST = Robot.GetEncoder();
        if(ENCODER_LIST[0] > ENCODER_LIST[3]) TURN = .1;
        if(ENCODER_LIST[0] < ENCODER_LIST[3]) TURN = -.1;
      }
      */
    }
    drive.arcadeDrive(MOVE, TURN);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new driveManual(RobotContainer.m_driveTrain));
  }
}
