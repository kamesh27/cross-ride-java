/**
 * 
 */
package com.crossover.techtrial.repositories;

import com.crossover.techtrial.model.Ride;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author crossover
 *
 */
@RestResource(exported = false)
public interface RideRepository extends CrudRepository<Ride, Long> {

    @Query("SELECT * FROM ride WHERE ride_start_time >= :startTime and ride_end_time <= :endTime")
    List<Ride> fetchRide(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
