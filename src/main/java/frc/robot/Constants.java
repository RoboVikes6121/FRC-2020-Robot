package frc.robot;

public final class Constants {

    //So a note about how this file is laid out...
    //Constants are supposed to be Constant. In Java, the keyword to do that is 'final'
    
    //Also, they should be in all caps with underscores, just as a naming convention thing. 

    //drive moters
    public static final int LEFT_DRIVE_MOTOR_1 = 0;
    public static final int LEFT_DRIVE_MOTOR_2 = 1;
    public static final int RIGHT_DRIVE_MOTOR_1 = 2;
    public static final int RIGHT_DRIVE_MOTOR_2 = 3;

    //joystices
    public static final int DRIVE_CONTROLER = 0;


    //Button / axis for jostick 1 (port 0)
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_STICK_X = 0;
    public static final int PRECISION_BUTTON = 5;

    //moter speeds
    public static final double MAX_MOVE_SPEED = 1;
    public static final double MIN_MOVE_SPEED = -1;
    public static final double PRECISION_MAX_MOVE_SPEED = .5;
    public static final double PRECISION_MIN_MOVE_SPEED = -.5;
}
