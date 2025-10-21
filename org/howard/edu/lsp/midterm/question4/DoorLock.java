/* Author: Fikir Demeke
 * Course: Large Scale Programming 
 * Date: October 20 2025
 * Midterm Exam
 */


package org.howard.edu.lsp.midterm.question4;

//
public class DoorLock extends Device implements Networked, BatteryPowered {
    //private fields
  private int batteryPercent;

  // Constructor
  public DoorLock(String id, String location, int initialBattery) {
    super(id, location);
    //0 - 100 range
    setBatteryPercent(initialBattery);
  }

  // Networked implementation here
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

  // BatteryPowered implementation
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

  // Status override
  @Override
  public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "DoorLock[id=" + getId() + ", loc=" + getLocation() +
           ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
  }
}

