package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.shootPto;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static driveTrain m_driveTrain = new driveTrain(); 
  public final static pto m_pto = new pto();
  public final static Intake m_Intake = new Intake();
  public final static Index m_Index = new Index();
  public final static LimeLight m_LimeLight = new LimeLight();

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  //private final XboxController SEC_CONTROLER = new XboxController(Constants.SEC_CONTROLER); 

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed){
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

  public JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.shootER_BUTTON);
  //public final JoystickButton DRIVER_y = new JoystickButton(DRIVE_CONTRALER, Constants.INTACK_BUTTON);

  public RobotContainer() {
    // Configure the button bindings
    DRIVER_X.whileHeld(new shootPto(m_pto));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }
}
