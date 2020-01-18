package frc.robot;

import com.ctre.phoenix.motorcontrol.Faults;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;
  private final static I2C.Port i2cPort = I2C.Port.kOnboard;
  private final static ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  Faults faults = new Faults();

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    // set up for encoders
    //
    driveTrain.LEFTMASTER.configFactoryDefault();
    driveTrain.RIGHTMASTER.configFactoryDefault();

    driveTrain.LEFTMASTER.setInverted(false);
    driveTrain.RIGHTMASTER.setInverted(false);

    driveTrain.LEFTMASTER.setSensorPhase(false);
    driveTrain.RIGHTMASTER.setSensorPhase(false);
  }

  public static double[] GetEncoder() {
    double[] ENCODER_LIST = new double[5];

    // encoider leftMaster or 0
    ENCODER_LIST[0] = driveTrain.LEFTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[1] = driveTrain.LEFTMASTER.getSelectedSensorPosition();
    // ENCODER_LIST[2] = driveTrain.LEFTMASTER.getMotorOutputPercent();

    // encoider rightMaster or 1
    ENCODER_LIST[3] = driveTrain.RIGHTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[4] = driveTrain.RIGHTMASTER.getSelectedSensorPosition();
    // ENCODER_LIST[5] = driveTrain.RIGHTMASTER.getMotorOutputPercent();
    return ENCODER_LIST;
  }

  public static void resetEncoder() {
    driveTrain.LEFTMASTER.setSelectedSensorPosition(0, 0, 10);
    driveTrain.RIGHTMASTER.setSelectedSensorPosition(0, 0, 10);
  }

  public static Color getColor() {
    Color COLOR = m_colorSensor.getColor();
    return COLOR;
  }

  public static double[] getIRProx(){
    double[] IRProx = new double[2];
    IRProx[0] = m_colorSensor.getIR();
    IRProx[1] = m_colorSensor.getProximity();
    return IRProx;
  }
  
  public static String getColorString(Color COLOR){
    String COLOR_STRING; 
    if(COLOR.red > .50 && COLOR.green < .40 && COLOR.blue < .40){
      COLOR_STRING = "RED";
    }else if(COLOR.green > .50 && COLOR.red < .30 && COLOR.blue < .20){
      COLOR_STRING = "GREEN";
    }else if(COLOR.blue > .30 && COLOR.red < .30 && COLOR.green < .50){
      COLOR_STRING = "BLUE";
    }else if(COLOR.green > .40 && COLOR.red > .40 && COLOR.blue < .20){
      COLOR_STRING = "YELLOW";
    }else{
      COLOR_STRING = "ERROR";
    }

    return COLOR_STRING;
  }  


  @Override
  public void robotPeriodic() {
    //getting encoders 
    double[] ENCODER_LIST = GetEncoder(); 
    //printing to SmartDashBoard
    //left motor set
    SmartDashboard.putNumber("LEFT ENCODER VOL", ENCODER_LIST[0]);
    SmartDashboard.putNumber("RIGHT ENCODER VOL", ENCODER_LIST[3]);
    //SmartDashboard.putNumber("LEFT MOTOR %", ENCODER_LIST[2]);
    //right motor set
    SmartDashboard.putNumber("LEFT ENCODER POS", ENCODER_LIST[1]);
    SmartDashboard.putNumber("RIGHT ENCODER POS", ENCODER_LIST[4]);
    //SmartDashboard.putNumber("RIGHT MOTER %", ENCODER_LIST[5]);

    //getting color
    Color COLOR = getColor();
    double[] IRProx = getIRProx();
    String STRING_COLOR = getColorString(COLOR);
    //printing colors 
    SmartDashboard.putNumber("Red", COLOR.red);
    SmartDashboard.putNumber("Green", COLOR.green);
    SmartDashboard.putNumber("Blue", COLOR.blue);
    SmartDashboard.putNumber("IR", IRProx[0]); 
    SmartDashboard.putNumber("Prox", IRProx[1]);

    SmartDashboard.putString("color", STRING_COLOR);

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
