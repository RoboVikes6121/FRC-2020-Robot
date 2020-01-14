package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.shotPto;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.pto;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static driveTrain m_driveTrain = new driveTrain(); 
  public final static pto m_pto = new pto();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  private final XboxController SEC_CONTROLER = new XboxController(Constants.SEC_CONTROLER); 

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed){
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

  public final JoystickButton DRIVER_X = new JoystickButton(SEC_CONTROLER, Constants.SHOTER_BUTTON);
  public final JoystickButton DRIVER_y = new JoystickButton(SEC_CONTROLER, Constants.INTACK_BUTTON);

  public RobotContainer() {
    // Configure the button bindings
    DRIVER_X.whileHeld(new shotPto(m_pto));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
