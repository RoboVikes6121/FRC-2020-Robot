package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.limeLigntDrive;
import frc.robot.commands.shootPto;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;
import frc.robot.subsystems.wof;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static driveTrain m_driveTrain = new driveTrain(); 
  public final static pto m_pto = new pto();
  public final static Intake m_Intake = new Intake();
  public final static Index m_Index = new Index();
  public final static wof m_wof = new wof();
  public final static LimeLight m_LimeLight = new LimeLight();

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  private final Joystick SEC_CONTROLER = new Joystick(Constants.SEC_CONTROLER); 

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed){
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

  public final JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_X);
  public final JoystickButton DRIVER_y = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_B);
  public final JoystickButton DRIVER_A = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_A);

  public RobotContainer() {
    // Configure the button bindings
    //DRIVER_X.whileHeld(new shootPto(m_pto));
    DRIVER_A.whileHeld(new limeLigntDrive(m_driveTrain, m_LimeLight));
    configureButtonBindings();
  }
  

  private void configureButtonBindings() {
    
  }

}