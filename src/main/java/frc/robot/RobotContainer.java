package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.intakeIn;
import frc.robot.commands.intakeOut;
import frc.robot.commands.intakeUpDown;
import frc.robot.commands.clime;
import frc.robot.commands.elvDown;
import frc.robot.commands.elvUp;
import frc.robot.commands.limeLightDrive;
import frc.robot.commands.shoot;
import frc.robot.commands.wofAuton;
import frc.robot.commands.wofManual;
import frc.robot.commands.wofUpDown;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.gyro;
import frc.robot.subsystems.pto;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.wof;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static driveTrain  m_drive = new driveTrain();
  public final static intake m_intake = new intake();
  public final static LimeLight m_LimeLight = new LimeLight();
  public final static pto m_pto = new pto();
  public final static shooter m_shooter = new shooter();
  public final static wof m_wof = new wof();
  public final static gyro m_gyro = new gyro();

  private final XboxController DRIVE_CONTRALER = new XboxController(Constants.DRIVE_CONTROLER);
  private final XboxController SEC_CONTROLER = new XboxController(Constants.SEC_CONTROLER);

  public double GetDriveRawAxis(int axis) {
    return DRIVE_CONTRALER.getRawAxis(axis);
  }

  public boolean GetRawButton(int pressed) {
    return DRIVE_CONTRALER.getRawButton(pressed);
  }

  // not used
  public final JoystickButton DRIVER_X = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_X);
  public final JoystickButton DRIVER_B = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_B);
  public final JoystickButton DRIVER_Y = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_Y);

  // used
  public final JoystickButton DRIVER_A = new JoystickButton(DRIVE_CONTRALER, Constants.BUTTON_LIME_AUTON);
  public final JoystickButton SEC_1 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_SHOOTER);
  public final JoystickButton SEC_2 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_IN);
  public final JoystickButton SEC_3 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_OUT);
  public final JoystickButton SEC_4 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_ELIVATOR_UP);
  public final JoystickButton SEC_5 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_ELIVATOR_DOWN);
  public final JoystickButton SEC_6 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_CLIMB);
  public final JoystickButton SEC_7 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF_UPDOWN);
  public final JoystickButton SEC_8 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF);
  public final JoystickButton SEC_9 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_WOF_MANUAL);
  public final JoystickButton SEC_10 = new JoystickButton(SEC_CONTROLER, Constants.BUTTON_INTAKE_UPDONW);

  public RobotContainer() {
    // Configure the button bindings
    DRIVER_A.whileHeld(new limeLightDrive( m_drive, m_LimeLight));

    // shooter
    SEC_1.whenHeld(new shoot(m_shooter, m_intake));

    // intake
    SEC_2.whenHeld(new intakeIn(m_intake));
    SEC_3.whenHeld(new intakeOut(m_intake));
    SEC_10.whenReleased(new intakeUpDown(m_intake));

    //elivator
    SEC_4.whenHeld(new elvUp(m_pto));
    SEC_5.whenHeld(new elvDown(m_pto));
    SEC_6.whenHeld(new clime(m_pto));

    //wof
    SEC_7.whenPressed(new wofUpDown(m_wof));
    SEC_8.whenPressed(new wofAuton(m_wof));
    SEC_9.whenHeld(new wofManual(m_wof));
    
    configureButtonBindings();
  }
  private void configureButtonBindings() {
    
  }
}
