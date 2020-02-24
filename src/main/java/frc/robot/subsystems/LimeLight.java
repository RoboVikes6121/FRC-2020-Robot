/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimeLight extends SubsystemBase {
  private final NetworkTable m_limelightTable;
  private double tv, tx, ta;
  private ArrayList<Double> m_targetList;
  private final int MAX_ENTRIES = 10;
  private static final String LED_MODE = "ledMode";
  private static final String CAM_MODE = "camMode";

  /**
   * Creates a new Vision.
   */
   public LimeLight() {
    m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    m_targetList = new ArrayList<Double>(MAX_ENTRIES);
  }

  public void disable() {
    m_limelightTable.getEntry(LED_MODE).setDouble(1.0); // force off
    m_limelightTable.getEntry(CAM_MODE).setDouble(1.0); // driver camera (stops vision processing)
    }
    public void enable() {
      m_limelightTable.getEntry(LED_MODE).setDouble(3.0); // set LED to on
      m_limelightTable.getEntry(CAM_MODE).setDouble(0.0); // set to vision mode
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    tv = m_limelightTable.getEntry("tv").getDouble(0);
    tx = m_limelightTable.getEntry("tx").getDouble(0);
    ta = m_limelightTable.getEntry("ta").getDouble(0);

    SmartDashboard.putNumber("tx", tx);
    SmartDashboard.putNumber("tv", tv);
    SmartDashboard.putNumber("ta", ta);
    
    if (m_targetList.size() == MAX_ENTRIES) {
      m_targetList.remove(0);
    }
    m_targetList.add(ta);
  }

  public double getTX() {
    return tx;
  }

  public double getTA() {
    double sum = 0;

    for (Double num : m_targetList) { 		      
      sum += num.doubleValue();
    }
    return sum/m_targetList.size();
  }

  public boolean isTargetValid() {
    return (tv < 1.0); 
  }
}