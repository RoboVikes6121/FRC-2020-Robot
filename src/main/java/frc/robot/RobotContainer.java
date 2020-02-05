package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.limeLigntDrive;
import frc.robot.commands.wofAuton;
import frc.robot.commands.wofUpDown;
import frc.robot.subsystems.Intack;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.wof;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static driveTrain m_driveTrain = new driveTrain();
  public final static Intack m_Intack = new Intack();
  public final static LimeLight m_LimeLight = new LimeLight();
  public final static pto m_pto = new pto();
  public final static shooter m_shooter = new shooter();
  public final static wof m_wof = new wof();

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  private final XboxController SEC_CONTROLER = new XboxController(Constants.SEC_CONTROLER); 

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed){
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

  //not used
  public final JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_X);
  public final JoystickButton DRIVER_B = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_B);
  public final JoystickButton DRIVER_Y = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_Y);
  public final JoystickButton SEC_1 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER);
  public final JoystickButton SEC_2 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_IN);
  public final JoystickButton SEC_3 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_OUT);
  public final JoystickButton SEC_4 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_ELIVATOR_UP);
  public final JoystickButton SEC_5 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_ELIVATOR_DOWN);
  public final JoystickButton SEC_6 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_CLIMB);
  public final JoystickButton SEC_7 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF_UPDOWN);
  public final JoystickButton SEC_8 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF);
  public final JoystickButton SEC_9 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF_MANUAL);

  //used 
  public final JoystickButton DRIVER_A = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_LIME_AUTON);

  public RobotContainer() {
    // Configure the button bindings
    DRIVER_A.whileHeld(new limeLigntDrive(m_driveTrain, m_LimeLight));

    // SEC_7.whenPressed(new wof);
    SEC_8.whenPressed(new wofAuton(m_wof));
    
    configureButtonBindings();
  }
`
  private void configureButtonBindings() {
    
  }
}
