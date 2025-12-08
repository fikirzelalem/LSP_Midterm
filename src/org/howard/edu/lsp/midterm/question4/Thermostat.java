/* Author: Fikir Demeke
 * Course: Large Scale Programming 
 * Date: October 20 2025
 * Midterm Exam
 * Thermostat class
 */

package org.howard.edu.lsp.midterm.question4;

//extends device and implements networked
public class Thermostat extends Device implements Networked {
  private double temperatureC;

  // Constructor
  public Thermostat(String id, String location, double initialTempC) {
    super(id, location);
    this.temperatureC = initialTempC;
  }

  // Accessors
  public double getTemperatureC() {
    return temperatureC;
  }

  public void setTemperatureC(double temperatureC) {
    this.temperatureC = temperatureC;
  }

  // Networked implementation
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

  // Status override
  @Override
  public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "Thermostat[id=" + getId() + ", loc=" + getLocation() +
           ", conn=" + connStatus + ", tempC=" + temperatureC + "]";
  }
}

