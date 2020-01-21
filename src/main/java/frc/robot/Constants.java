package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

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

    //intake and index motors 
    public static final int INTAKE_MOTOR = 6;
    public static final int INDEX_MOTOR = 7;

    //joysticks
    public static final int DRIVE_CONTROLER = 0;
    public static final int SEC_CONTROLER = 1;


    //Button / axis for joystick 1 (port 0)
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_STICK_X = 0;
    public static final int PRECISION_BUTTON = 5; // left trigger 
    public static final int shootER_BUTTON = 3; // x
    public static final int INTACK_BUTTON = 4; // y 

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
    public static final double INDEX_SPEED = .35;
    public static final double INTAKE_SPEED = .75; 
    public static final double CLIMB_SPEED = .75;

}
