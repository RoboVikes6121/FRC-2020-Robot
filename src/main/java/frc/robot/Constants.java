/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //So a note about how this file is laid out...
    //Constants are supposed to be Constant. In Java, the keyword to do that is 'final'
    //Such as:
    public static final int LEFT_DRIVE_MOTOR_1 = 0;
    //Also, they should be in all caps with underscores, just as a naming convention thing. 


    //drive moters
    // public static int left_drive_moter_1 = 0;
    public static int left_drive_moter_2 = 1;
    public static int right_drive_moter_1 = 2;
    public static int right_drive_moter_2 = 3;

    //joystices
    public static int drive_controller = 0;

    //moter speeds
    public static double max_move_speed = .5;
    public static double min_move_speed = .5;
}
