/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class limeLight {

    // private static NetworkTableInstance limelight;
    
   
   //Method that returns a boolean for when the limelight has a target in its field of vision
   public boolean targetValue(){
        final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        if(check == 0)
        return true;
        else
        return false;
    }
    // Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
    public double horizontalX(){
        final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        return check;
    }
    // Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
    public double horizontalY(){
        final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        return check;
    }
    // Target Area (0% of image to 100% of image)
    public double targetArea(){
        final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        return check;
    }
    // Skew or rotation (-90 degrees to 0 degrees)
    public double rotation(){
        final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
        return check;
    }
   //public double 
}
