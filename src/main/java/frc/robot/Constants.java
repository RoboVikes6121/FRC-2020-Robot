package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

public final class Constants {

    //drive                                                      SUB - DONE   COMMAND - DONE   AUTO - DONE 
    public static final int LEFT_DRIVE_MOTOR_1 = 0;
    public static final int LEFT_DRIVE_MOTOR_2 = 1;
    public static final int RIGHT_DRIVE_MOTOR_1 = 2;
    public static final int RIGHT_DRIVE_MOTOR_2 = 3;

    public static final double MAX_MOVE_SPEED = 1;
    public static final double MIN_MOVE_SPEED = -1;
    public static final double PRECISION_MAX_MOVE_SPEED = .5;
    public static final double PRECISION_MIN_MOVE_SPEED = -.5;

    //pto                                                         SUB - DONE 
    public static final int MASTER_PTO_MOTOR = 4;
    public static final int SLAVE_PTO_MOTOR = 5;

    public static final int PTO_SOUL = 0;

    public static final double CLIMB_SPEED = .25; // dont know speed yet
    public static final double ELIVATOR_SPEED = .25; // dont know speed yet
    public static final double ELIVATOR_POS = 1000; // dont know speed yet
    public static final double CLIMB_POS = 1000; // dont know speed yet

    //WOF                                                         SUB - DONE   COMMAND - DONE   AUTO - none 
    public static final int WOF_MOTOR = 7;

    public static final int WOF_OUT_SOUL = 1;
    public static final int WOF_IN_SOUL = 2;

    public static final double WOF_SPEED = .25; // dont know speed yet

    //intack                                                      SUB - DONE   COMMAND - DONE 
    public static final int INTAKE_MOTOR = 6;

    public static final int INTAKE_OUT_SOUL = 3;
    public static final int INTAKE_IN_SOUL = 4;

    public static final double INDEX_SPEED = .70; // dont know speed yet
    public static final double INTAKE_SPEED = .75; // dont know speed yet

    //shooter                                             SUB - DONE   COMMAND - DONE 
    public static final int SHOOTER_MOTOR = 8;

    public static final double SHOOTER_SPEED = .50;
    public static final double SHOOTER_SPEED_VOL = 21000; // dont know speed yet

    //joysticks
    public static final int DRIVE_CONTROLER = 0;
    public static final int SEC_CONTROLER = 1;

    //Button / axis for jostick 1 (port 0)
    public static final int LEFT_STICK_Y = 1;
    public static final int LEFT_STICK_X = 0;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_LIME_AUTON = 1; // A button
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 0;

    public static final int PRECISION_BUTTON = 5; // left trigger 
    

    //Secondary controller (Thrustmaster)
    public static final int BUTTON_SHOOTER = 1;
    public static final int BUTTON_INTAKE_IN = 2;
    public static final int BUTTON_INTAKE_OUT = 3;
    public static final int BUTTON_CLIMB = 4;
    public static final int BUTTON_ELIVATOR_UP = 5;
    public static final int BUTTON_ELIVATOR_DOWN = 6;
    public static final int BUTTON_WOF_UPDOWN = 7;
    public static final int BUTTON_WOF = 8;
    public static final int BUTTON_WOF_MANUAL = 9;

    //limeLight
    public static final double LIMELIGHT_SPEED_MAX = .75;
    public static final double LIMELIGHT_SPEED_MIN = -.75; 
    public static final double STREEING_KP = .15;
    public static final double MIN_TARGET_AREA = 3;
    public static final double DRIVER_KP = .26;
    public static final double MAX_DRIVE = 0.7;

    public static final int FLAG_COUNT_MAX = 50;

    //colors (r, g, b)
    public static final Color RED_TARGET = ColorMatch.makeColor(.561, .232, .114);
    public static final Color GREEN_TARGET = ColorMatch.makeColor(.197, .561, .240);
    public static final Color BLUE_TARGET = ColorMatch.makeColor(.143, .427, .429);
    public static final Color YELLOW_TARGET = ColorMatch.makeColor(.361, .524, .113);

    //gyro
    public static final int GYROPORT = 0;
}
