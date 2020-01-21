package frc.robot;

import com.ctre.phoenix.motorcontrol.Faults;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Auton;
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;
  private final static I2C.Port i2cPort = I2C.Port.kOnboard;
  
  private final static ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final static ColorMatch m_colorMatcher = new ColorMatch();


  Faults faults = new Faults();

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    //adding color match
    m_colorMatcher.addColorMatch(Constants.RED_TARGET);
    m_colorMatcher.addColorMatch(Constants.GREEN_TARGET);
    m_colorMatcher.addColorMatch(Constants.BLUE_TARGET);
    m_colorMatcher.addColorMatch(Constants.YELLOW_TARGET);

    // set up for encoders
    resetEncoder();
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

  public static char gameData(){
    String DATA = DriverStation.getInstance().getGameSpecificMessage();

    if(DATA.charAt(0) == 'R' ){
      return 'R';
    }else if(DATA.charAt(0) == 'G'){
      return 'G';
    }else if(DATA.charAt(0) == 'B'){
      return 'B';
    }else if(DATA.charAt(0) == 'Y'){
      return 'Y';
    }else{
      return 'n';
    }
  }
  
  public static String getColorString(Color COLOR){
    String COLOR_STRING;
    ColorMatchResult MATCH = m_colorMatcher.matchClosestColor(COLOR);

    if(MATCH.color == Constants.RED_TARGET){
      COLOR_STRING = "RED";
    }else if(MATCH.color == Constants.GREEN_TARGET){
      COLOR_STRING = "GREEN";
    }else if(MATCH.color == Constants.BLUE_TARGET){
      COLOR_STRING = "BLUE";
    }else if(MATCH.color == Constants.YELLOW_TARGET){
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
  public void autonomousInit() {  // autou is in inches 
    int flag = 0;
    if(flag == 0){
      m_autonomousCommand = new Auton(RobotContainer.m_driveTrain, 12, 12);
    }

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
