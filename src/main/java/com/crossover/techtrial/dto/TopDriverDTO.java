/**
 * 
 */
package com.crossover.techtrial.dto;

/**
 * @author crossover
 *
 */
public class TopDriverDTO {
  
  /**
   * Constructor for TopDriverDTO
   * @param name
   * @param email
   * @param totalRideDurationInSeconds
   * @param maxRideDurationInSecods
   * @param averageDistance
   */

  private String name;
  
  private String email;
  
  private Long totalRideDurationInSeconds;
  
  private Long maxRideDurationInSeconds;
  
  private Double averageDistance;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getTotalRideDurationInSeconds() {
    return totalRideDurationInSeconds;
  }

  public void setTotalRideDurationInSeconds(Long totalRideDurationInSeconds) {
    this.totalRideDurationInSeconds = totalRideDurationInSeconds;
  }

  public Long getMaxRideDurationInSeconds() {
    return maxRideDurationInSeconds;
  }

  public void setMaxRideDurationInSeconds(Long maxRideDurationInSeconds) {
    this.maxRideDurationInSeconds = maxRideDurationInSeconds;
  }

  public Double getAverageDistance() {
    return averageDistance;
  }

  public void setAverageDistance(Double averageDistance) {
    this.averageDistance = averageDistance;
  }
  
  
    
}
