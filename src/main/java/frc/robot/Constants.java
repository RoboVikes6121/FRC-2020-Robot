package frc.robot;

<<<<<<< Updated upstream
=======
import edu.wpi.first.wpilibj.GenericHID;

>>>>>>> Stashed changes
public final class Constants {

    //So a note about how this file is laid out...
    //Constants are supposed to be Constant. In Java, the keyword to do that is 'final'
    
    //Also, they should be in all caps with underscores, just as a naming convention thing. 

    //drive moters
    public static final int LEFT_DRIVE_MOTOR_1 = 0;
    public static final int LEFT_DRIVE_MOTOR_2 = 1;
    public static final int RIGHT_DRIVE_MOTOR_1 = 2;
    public static final int RIGHT_DRIVE_MOTOR_2 = 3;

    //pto moters 
    public static final int MASTER_PTO_MOTOR = 4;
    public static final int SLAVE_PTO_MOTOR = 5;

    //intack and index moters 
    public static final int INTAKE_MOTOR = 6;
    public static final int INDEX_MOTOR = 7;

    //joystices
    public static final int DRIVE_CONTROLER = 0;
    public static final int SEC_CONTROLER = 1;


    //Button / axis for jostick 1 (port 0)
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_STICK_X = 0;
<<<<<<< Updated upstream
    public static final int LEFT_BUTTON_B = 2;
    public static final int LEFT_BUTTON_A = 1;

    public static final int PRECISION_BUTTON = 5; // left trigger 
   
=======
    public static final int PRECISION_BUTTON = 5; // left trigger 
    public static final int shootER_BUTTON = 3; // x
    public static final int INTACK_BUTTON = 4; // y 
>>>>>>> Stashed changes

    //moter speeds
    public static final double MAX_MOVE_SPEED = 1;
    public static final double MIN_MOVE_SPEED = -1;
    public static final double PRECISION_MAX_MOVE_SPEED = .5;
    public static final double PRECISION_MIN_MOVE_SPEED = -.5;
    public static final double SHOOTER_SPEED = 1;
    public static final double HIGH_GOAL_SPEED = 0; // dont know speed yet
    public static final double LOW_GOAL_SPEED = 0; // dont know speed yet
<<<<<<< Updated upstream
    public static final double INDEX_SPEED = .75;
    public static final double INTAKE_SPEED = .75; 
    public static final double CLIMB_SPEED = .75;
=======
    public static final double INDEX_SPEED = .35;
    public static final double INTAKE_SPEED = .75; 
    public static final double CLIMB_SPEED = .75;
<<<<<<< Updated upstream
=======
    public static final double LIMELIGHT_SPEED_MAX = .75;
    public static final double LIMELIGHT_SPEED_MIN = -.75;
>>>>>>> Stashed changes

    // limeLight aim high goal
    public static final double STEER_K = 0.03;
    public static final double DRIVE_K = 0.26;
    public static final double DESIRED_TARGET_AREA = 13.0;
    public static final double MAX_DRIVE = 0.7;
>>>>>>> Stashed changes
}
