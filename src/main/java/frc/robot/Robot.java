package frc.robot;

import com.ctre.phoenix.motorcontrol.Faults;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.driveTrain;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;

  Faults faults = new Faults();

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    //set up for encoders
    //
    driveTrain.LEFTMASTER.configFactoryDefault();
    driveTrain.RIGHTMASTER.configFactoryDefault();

    driveTrain.LEFTMASTER.setInverted(false);
    driveTrain.RIGHTMASTER.setInverted(false);

    driveTrain.LEFTMASTER.setSensorPhase(false);
    driveTrain.RIGHTMASTER.setSensorPhase(false);
  }

  public double[] GetEncoder(){
    double[] ENCODER_LIST = new double[5];
    
    //encoider leftMaster or 0
    ENCODER_LIST[0] = driveTrain.LEFTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[1] = driveTrain.LEFTMASTER.getSelectedSensorPosition();
    ENCODER_LIST[2] = driveTrain.LEFTMASTER.getMotorOutputPercent();

    //encoider rightMaster or 1
    ENCODER_LIST[3] = driveTrain.RIGHTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[4] = driveTrain.RIGHTMASTER.getSelectedSensorPosition();
    ENCODER_LIST[5] = driveTrain.RIGHTMASTER.getMotorOutputPercent();
    return ENCODER_LIST;
  } 


  @Override
  public void robotPeriodic() {
    //getting encoders 
    double[] ENCODER_LIST = GetEncoder(); 
    //printing to SmartDashBoard
    //left motor set
    SmartDashboard.putNumber("LEFT ENCODER VOL", ENCODER_LIST[0]);
    SmartDashboard.putNumber("LEFT ENCODER POS", ENCODER_LIST[1]);
    SmartDashboard.putNumber("LEFT MOTOR %", ENCODER_LIST[2]);
    //right motor set
    SmartDashboard.putNumber("RIGHT ENCODER VOL", ENCODER_LIST[3]);
    SmartDashboard.putNumber("RIGHT ENCODER POS", ENCODER_LIST[4]);
    SmartDashboard.putNumber("RIGHT MOTER %", ENCODER_LIST[5]);

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
