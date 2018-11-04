/**
 * 
 */
package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import com.crossover.techtrial.dto.TopDriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.repositories.RideRepository;

/**
 * @author crossover
 *
 */
@Service
public class RideServiceImpl implements RideService{

  @Autowired
  RideRepository rideRepository;

  @Override
  public Ride save(Ride ride) {
    return rideRepository.save(ride);
  }

  @Override
  public Ride findById(Long rideId) {
    Optional<Ride> optionalRide = rideRepository.findById(rideId);
    if (optionalRide.isPresent()) {
      return optionalRide.get();
    }else return null;
  }

  @Override
  public List<TopDriverDTO> getTopDrivers(Long count, LocalDateTime startTime, LocalDateTime endTime) {
    List<Ride> rides = rideRepository.fetchRide(startTime, endTime);
    List<TopDriverDTO> allDrivers = new ArrayList<>();
    for (Ride temp: rides){
      TopDriverDTO details = new TopDriverDTO();
      details.setName(temp.getDriver().getName());
      details.setEmail(temp.getDriver().getEmail());
      details.setTotalRideDurationInSeconds(getRideDuration(temp.getRideStartTime(), temp.getRideEndTime()));
      details.setAverageDistance(getAverageDistance(rides, temp.getDriver().getId()));
      details.setMaxRideDurationInSeconds(getMaxRideDuration(rides, temp.getDriver().getId()));
      allDrivers.add(details);
    }
    return allDrivers;
  }

  private Long getRideDuration(LocalDateTime startTime, LocalDateTime endTime){
    long seconds = ChronoUnit.SECONDS.between(startTime, endTime);
    return seconds;
  }

  private Double getAverageDistance(List<Ride> rides, Long driverId){
    Double totalDistance = 0.0;
    Double count = 0.0;
    for (Ride temp: rides){
      if(temp.getDriver().getId() == driverId){
        totalDistance = totalDistance + temp.getDistance();
        count = count + 1;
      }
    }
    Double averageDistance = totalDistance/count;
    return averageDistance;
  }

  private Long getMaxRideDuration(List<Ride> rides, Long driverId){
    Long maxRideDuration = null;
    for(Ride temp: rides){
      if(temp.getDriver().getId() == driverId){
        Long rideDuration = getRideDuration(temp.getRideStartTime(), temp.getRideEndTime());
        if(maxRideDuration == null){
          maxRideDuration = rideDuration;
        }
        else{
          if(maxRideDuration < rideDuration){
            maxRideDuration = rideDuration;
          }
        }
      }
    }
    return maxRideDuration;
  }

}


