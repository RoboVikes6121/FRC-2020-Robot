package frc.robot;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.Faults;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Auton.autonPink;
import frc.robot.commands.Auton.endAuton;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;
import frc.robot.subsystems.shooter;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;
  private final static I2C.Port i2cPort = I2C.Port.kOnboard;
  private final static ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
 

  Faults faults = new Faults();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  public static final boolean verbose = false;
  private ArrayList<String> commandList;

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    
    // Adds camra to the smart dashbord
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();
    
    // Resets the Gyro and encoders to zero
    resetEncoder();
    RobotContainer.m_gyro.reset();
    
    
    // autonomous chooser on the dashboard.
    m_chooser.setDefaultOption("Do Nothing", new endAuton());
    m_chooser.addOption("Pink", new autonPink(RobotContainer.m_driveTrain, RobotContainer.m_LimeLight, RobotContainer.m_gyro, 
    RobotContainer.m_shooter, RobotContainer.m_intake));
    m_robotContainer = new RobotContainer();
    
    commandList = new ArrayList<String>();
    if (verbose) {
      CommandScheduler.getInstance().onCommandExecute(command -> {
        commandList.add(command.getName());
      });
    }
    SmartDashboard.putData(m_chooser);
  
  }

  public static double[] GetEncoder() {
    double[] ENCODER_LIST = new double[9];

    // encoider leftMaster or 0,1
    ENCODER_LIST[0] = driveTrain.LEFTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[1] = driveTrain.LEFTMASTER.getSelectedSensorPosition();

    // encoider rightMaster or 2,3
    ENCODER_LIST[2] = driveTrain.RIGHTMASTER.getSelectedSensorVelocity();
    ENCODER_LIST[3] = driveTrain.RIGHTMASTER.getSelectedSensorPosition();

    // encoider PTO master or 4,5
    //ENCODER_LIST[4] = pto.MASTER.getSelectedSensorVelocity();
    //ENCODER_LIST[5] = pto.MASTER.getSelectedSensorPosition();

    // encoder Shooter master or 6,7
    //ENCODER_LIST[6] = shooter.MASTER.getSelectedSensorVelocity();
    //ENCODER_LIST[7] = shooter.MASTER.getSelectedSensorPosition();

    return ENCODER_LIST;
  }

  public static void resetEncoder() {
    driveTrain.LEFTMASTER.setSelectedSensorPosition(0, 0, 10);
    driveTrain.RIGHTMASTER.setSelectedSensorPosition(0, 0, 10);
    pto.MASTER.setSelectedSensorPosition(0, 0, 10);
    shooter.MASTER.setSelectedSensorPosition(0, 0, 10);
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


  @Override
  public void robotPeriodic() {
    //getting encoders 
    double[] ENCODER_LIST = GetEncoder(); 
    //printing to SmartDashBoard
    //left motor set
    SmartDashboard.putNumber("LEFT ENCODER VOL", ENCODER_LIST[0]);
    SmartDashboard.putNumber("RIGHT ENCODER VOL", ENCODER_LIST[2]);
    //SmartDashboard.putNumber("LEFT MOTOR %", ENCODER_LIST[2]);
    //right motor set
    SmartDashboard.putNumber("LEFT ENCODER POS", ENCODER_LIST[1]);
    SmartDashboard.putNumber("RIGHT ENCODER POS", -ENCODER_LIST[3]);
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

    SmartDashboard.putNumber("Gyro", RobotContainer.m_gyro.getAngle());

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
    m_autonomousCommand = m_chooser.getSelected();
    m_autonomousCommand = new  autonPink(RobotContainer.m_driveTrain, RobotContainer.m_LimeLight, RobotContainer.m_gyro, RobotContainer.m_shooter, RobotContainer.m_intake);
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    RobotContainer.m_LimeLight.disable();
    RobotContainer.m_gyro.reset();
    resetEncoder();
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
