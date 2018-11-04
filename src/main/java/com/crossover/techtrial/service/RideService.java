/**
 * 
 */
package com.crossover.techtrial.service;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Ride;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * RideService for rides.
 * @author crossover
 *
 */
public interface RideService {
  
  public Ride save(Ride ride);
  
  public Ride findById(Long rideId);

  public List<TopDriverDTO> getTopDrivers(Long count, LocalDateTime startTime, LocalDateTime endTime);
  

}
