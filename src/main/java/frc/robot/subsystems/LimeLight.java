/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimeLight extends SubsystemBase {
  /**
   * Creates a new limeLight.
   */
   
   //Method that returns a boolean for when the limelight has a target in its field of vision
   public static boolean targetValue(){
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    if(check < 1)
    return false;
    else
    return true;
}
// Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
public static double horizontalX() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    return check;
}

// Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees
// | LL2: -24.85 to 24.85 degrees)
public static double horizontalY() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    return check;
}

// Target Area (0% of image to 100% of image)
public static double targetArea() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    return check;
}

// Skew or rotation (-90 degrees to 0 degrees)
public static double rotation() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
    return check;
}

// The pipeline’s latency contribution (ms) Add at least 11ms for image capture
// latency.
public static double pipelineLatency() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0);
    return check;
}

// Sidelength of shortest side of the fitted bounding box (pixels)
public static double sidelengthSS() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
    return check;
}

// Sidelength of longest side of the fitted bounding box (pixels)
public static double sidelengthLS() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
    return check;
}

// Horizontal sidelength of the rough bounding box (0 - 320 pixels)
public static double sidelengthHS() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
    return check;
}

// Vertical sidelength of the rough bounding box (0 - 320 pixels)
public static double sidelengthVS() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
    return check;
}

// True active pipeline index of the camera (0 .. 9)
public static double activePipeline() {
    final double check = NetworkTableInstance.getDefault().getTable("limelight").getEntry("getpipe").getDouble(0);
    return check;
}

/*
 * 0 use the LED Mode set in the current pipeline 1 force off 2 force blink 3
 * force on
 */
public static void setLEDState(int s) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(s);
}

/*
 * camMode Sets limelight’s operation mode 0 Vision processor 1 Driver Camera
 * (Increases exposure, disables vision processing)
 */
public static void setOpMode(int o) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(o);
}

/*
 * pipeline Sets limelight’s current pipeline 0 .. 9 Select pipeline 0..9
 */
public static void pipeline(int p) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(p);
}

/*
 * stream Sets limelight’s streaming mode 0 Standard - Side-by-side streams if a
 * webcam is attached to Limelight 1 PiP Main - The secondary camera stream is
 * placed in the lower-right corner of the primary camera stream 2 PiP Secondary
 * - The primary camera stream is placed in the lower-right corner of the
 * secondary camera stream
 */
public static void setStreamMode(int s) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(s);
}

/*
 * snapshot Allows users to take snapshots during a match 0 Stop taking
 * snapshots 1 Take two snapshots per second
 */
public static void snapShot(int s) {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(s);
}

public static void updateLimeLightTracking() {

    final double STEER_K = Constants.STEER_K; // how hard to turn toward the target
    final double DRIVE_K = Constants.DRIVE_K; // how hard to drive fwd toward the target
    final double DESIRED_TARGET_AREA = Constants.DESIRED_TARGET_AREA; // Area of the target when the robot reaches
                                                                      // the wall
    final double MAX_DRIVE = Constants.MAX_DRIVE; // Simple speed limit so we don't drive too fast

    boolean m_LimeLightHasValidtarget = false;
    double m_LimeLightDriveCommand = 0.0;
    double m_LimeLightSteerCommand = 0.0;

    boolean tv = targetValue();
    double tx = horizontalX();
    double ty = horizontalY();
    double ta = targetArea();

    if(!targetValue())
    {
        m_LimeLightHasValidtarget = false;
        m_LimeLightDriveCommand = 0.0;
        m_LimeLightSteerCommand = 0.0;
        return;
    }

    m_LimeLightHasValidtarget = true;
    
    // Start with proportional steering
    double steer_cmd = tx * STEER_K;
    m_LimeLightSteerCommand = steer_cmd;

    // try to drive forward until the target area reaches our desired area
    double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

    // don't let the robot drive too fast into the goal

    if(drive_cmd > MAX_DRIVE)
    {
        drive_cmd = MAX_DRIVE;
    }
    m_LimeLightDriveCommand = drive_cmd;

}
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
