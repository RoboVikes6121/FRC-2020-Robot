package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX; //Today I learned that WPI_TalonSRX just extends TalonSRX and adds in the WPI functionality - Andrew 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.driveManual;

public class driveTrain extends SubsystemBase {

  public static WPI_TalonSRX LEFTMASTER = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_1);  // encoders 0,1
  WPI_TalonSRX LEFTSLAVE = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_2);
  public static WPI_TalonSRX RIGHTMASTER = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_1); // encoders 2,3
  WPI_TalonSRX RIGHTSLAVE = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_2);

  // Creates Differential Drive
  final static DifferentialDrive drive = new DifferentialDrive(LEFTMASTER, RIGHTMASTER);

  public driveTrain() {
    // Sets the slave to follow master
    LEFTSLAVE.follow(LEFTMASTER);
    RIGHTSLAVE.follow(RIGHTMASTER);

    // set motor prefrence
    LEFTMASTER.setNeutralMode(NeutralMode.Brake);
    LEFTSLAVE.setNeutralMode(NeutralMode.Brake);
    RIGHTMASTER.setNeutralMode(NeutralMode.Brake);
    RIGHTSLAVE.setNeutralMode(NeutralMode.Brake);

    // set up encoders
    driveTrain.LEFTMASTER.configFactoryDefault();
    driveTrain.RIGHTMASTER.configFactoryDefault();

    driveTrain.LEFTMASTER.setInverted(false);
    driveTrain.RIGHTMASTER.setInverted(false);

    driveTrain.LEFTMASTER.setSensorPhase(false);
    driveTrain.RIGHTMASTER.setSensorPhase(false);
  }

  public void manualDrive(double MOVE, double TURN, boolean PRECISION_BUTTON_IS_PRESSED) {
    // setting min and max speed
    if (PRECISION_BUTTON_IS_PRESSED == true) { // setting speeds when the button is pressed
      if (MOVE > Constants.PRECISION_MAX_MOVE_SPEED)
        MOVE = Constants.PRECISION_MAX_MOVE_SPEED;
      if (MOVE < Constants.PRECISION_MIN_MOVE_SPEED)
        MOVE = Constants.PRECISION_MIN_MOVE_SPEED;
      if (TURN > Constants.PRECISION_MAX_MOVE_SPEED)
        TURN = Constants.PRECISION_MAX_MOVE_SPEED;
      if (TURN < Constants.PRECISION_MIN_MOVE_SPEED)
        TURN = Constants.PRECISION_MIN_MOVE_SPEED;
    } else { // setting speeds when the button is not pushed
      if (MOVE > Constants.MAX_MOVE_SPEED)
        MOVE = Constants.MAX_MOVE_SPEED;
      if (MOVE < Constants.MIN_MOVE_SPEED)
        MOVE = Constants.MIN_MOVE_SPEED;
      if (TURN > Constants.MAX_MOVE_SPEED)
        TURN = Constants.MAX_MOVE_SPEED;
      if (TURN < Constants.MIN_MOVE_SPEED)
        TURN = Constants.MIN_MOVE_SPEED;
    }
    drive.arcadeDrive(-MOVE, TURN);
  }

  public static void autonDrive(double power) {
    double kP = .001;
    double error = 0 - RobotContainer.m_gyro.getAngle();
    double turn = kP * error;
    drive.arcadeDrive(-power, turn);
  }

  double sumError = 0;
  double priError = 0;
  double deri = 0;

  public boolean autonDriveTurn(double angle) {
    double error = angle - RobotContainer.m_gyro.getAngle();
    double turn = 0;
    if(error < 0){
      turn = .5;
    }
    if(error > 0){
      turn = -.5;
    }
    drive.arcadeDrive(0, -turn);

    if(Math.abs(error) <= 2){
      return true;
    }else{
      return false;
    }
  }

  public void autonEnd(){
    LEFTMASTER.set(ControlMode.PercentOutput, 0);
    RIGHTMASTER.set(ControlMode.PercentOutput, 0);
  }
  
  public void limeLightDrive(double MOVE, double TURN){
      if(MOVE > Constants.LIMELIGHT_SPEED_MAX) MOVE = Constants.LIMELIGHT_SPEED_MAX;
      if(MOVE < Constants.LIMELIGHT_SPEED_MIN) MOVE = Constants.LIMELIGHT_SPEED_MIN;
      if(TURN > Constants.LIMELIGHT_SPEED_MAX) TURN = Constants.LIMELIGHT_SPEED_MAX;
      if(TURN < Constants.LIMELIGHT_SPEED_MIN) TURN = Constants.LIMELIGHT_SPEED_MIN;
    drive.arcadeDrive(MOVE, TURN);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new driveManual(RobotContainer. m_drive));
  }
}
