/* Author: Fikir Demeke
 * Course: Large Scale Programming 
 * Date: October 20 2025
 * Midterm Exam
 * Camera class
 */

package org.howard.edu.lsp.midterm.question4;

//camera extends device and implements networked and batterypowered
public class Camera extends Device implements Networked, BatteryPowered {
    //private fields
  private int batteryPercent;

  // Constructor
  public Camera(String id, String location, int initialBattery) {
    super(id, location);
    //initialize battery 0...100
    setBatteryPercent(initialBattery); 
  }

  // Networked implementation for methods
  @Override
  public void connect() {
    setConnected(true);
  }

  @Override
  public void disconnect() {
    setConnected(false);
  }

  @Override
  public boolean isConnected() {
    return super.isConnected();
  }

  // BatteryPowered implementation for methods
  @Override
  public int getBatteryPercent() {
    return batteryPercent;
  }

  @Override
  public void setBatteryPercent(int percent) {
    if (percent < 0 || percent > 100) {
      throw new IllegalArgumentException("battery 0..100");
    }
    this.batteryPercent = percent;
  }

  // Status 
  @Override
  public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "Camera[id=" + getId() + ", loc=" + getLocation() +
           ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
  }
}

