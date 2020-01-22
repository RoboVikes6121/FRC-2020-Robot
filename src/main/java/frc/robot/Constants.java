package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

public final class Constants {

    //So a note about how this file is laid out...
    //Constants are supposed to be Constant. In Java, the keyword to do that is 'final'
    
    //Also, they should be in all caps with underscores, just as a naming convention thing. 

    //drive motors
    public static final int LEFT_DRIVE_MOTOR_1 = 0;
    public static final int LEFT_DRIVE_MOTOR_2 = 1;
    public static final int RIGHT_DRIVE_MOTOR_1 = 2;
    public static final int RIGHT_DRIVE_MOTOR_2 = 3;

    //pto motors 
    public static final int MASTER_PTO_MOTOR = 4;
    public static final int SLAVE_PTO_MOTOR = 5;
    public static final int PTO_SOUL = 0;

    //WOF
    public static final int WOF_MOTOR = 8;

    //intack and index moters 
    public static final int INTAKE_MOTOR = 6;
    public static final int INDEX_MOTOR = 7;

    //joysticks
    public static final int DRIVE_CONTROLER = 0;
    public static final int SEC_CONTROLER = 1;

    //Button / axis for jostick 1 (port 0)
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_STICK_X = 0;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_A = 1;
    public static final int BUTTON_X = 3;

    public static final int PRECISION_BUTTON = 5; // left trigger 
   

    //Secondary controller (Thrustmaster)
    public static final int SHOOTER_IN = 1;
    public static final int SHOOTER_OUT = 2;
    public static final int INTAKE_IN = 3;
    public static final int INTAKE_OUT = 4;
    public static final int CLIMB_PULL = 5;
    public static final int CLIMB_PUSH = 6;
    public static final int SHOOTER_LEVEL_ONE = 7;
    public static final int SHOOTER_LEVEL_TWO = 8;

    //motor speeds
    public static final double MAX_MOVE_SPEED = 1;
    public static final double MIN_MOVE_SPEED = -1;
    public static final double PRECISION_MAX_MOVE_SPEED = .5;
    public static final double PRECISION_MIN_MOVE_SPEED = -.5;
    public static final double SHOOTER_SPEED = 1;
    public static final double HIGH_GOAL_SPEED = 0; // dont know speed yet
    public static final double LOW_GOAL_SPEED = 0; // dont know speed yet
    public static final double INDEX_SPEED = .70;
    public static final double INTAKE_SPEED = .75; 
    public static final double CLIMB_SPEED = .75;
    public static final double WOF_SPEED = .25; // dont know speed yet
     

    //colors (r, g, b)
    public static final Color RED_TARGET = ColorMatch.makeColor(.561, .232, .114);
    public static final Color GREEN_TARGET = ColorMatch.makeColor(.197, .561, .240);
    public static final Color BLUE_TARGET = ColorMatch.makeColor(.143, .427, .429);
    public static final Color YELLOW_TARGET = ColorMatch.makeColor(.361, .524, .113);

    // limeLight aim high goal
    public static final double STEER_K = 0.03;
    public static final double DRIVE_K = 0.26;
    public static final double DESIRED_TARGET_AREA = 13.0;
    public static final double MAX_DRIVE = 0.7;
}
