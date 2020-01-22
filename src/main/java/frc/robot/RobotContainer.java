package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.intakeIn;
import frc.robot.commands.shootPto;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static driveTrain m_driveTrain = new driveTrain(); 
  public final static pto m_pto = new pto();
  public final static Intake m_Intake = new Intake();
  public final static Index m_Index = new Index();

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  //private final XboxController SEC_CONTROLER = new XboxController(Constants.SEC_CONTROLER); 

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed){
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

<<<<<<< HEAD
  public JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.shootER_BUTTON);
  //public final JoystickButton DRIVER_y = new JoystickButton(DRIVE_CONTRALER, Constants.INTACK_BUTTON);
=======
  //not used
  public final JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_X);
  public final JoystickButton DRIVER_B = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_B);
  public final JoystickButton DRIVER_Y = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_Y);
  public final JoystickButton SEC_1 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER_IN);
  public final JoystickButton SEC_2 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER_OUT);
  public final JoystickButton SEC_3 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_IN);
  public final JoystickButton SEC_4 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_OUT);
  public final JoystickButton SEC_5 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_CLIMB_PULL);
  public final JoystickButton SEC_6 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_CLIMB_PUSH);
  public final JoystickButton SEC_7 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER_LEVEL_ONE);  
  public final JoystickButton SEC_8 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER_LEVEL_TWO);

  //used 
  public final JoystickButton DRIVER_A = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_LIME_AUTON);
>>>>>>> f0f7d66a32bfb41b6babff4ad86dbcbc28ed1884

  public RobotContainer() {
    // Configure the button bindings
    DRIVER_X.whileHeld(new shootPto(m_pto));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }
}
