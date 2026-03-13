package com.amit.rider.repository;

import com.amit.rider.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Custom query to find locations by driver ID
    Location findFirstByDriverIdOrderByCreatedAtDesc(Long driverId);

    // Spatial query to find nearby locations
    @Query("SELECT l FROM Location l WHERE function('ST_DWithin', l.location, function('ST_MakePoint', :longitude, :latitude), :radiusKm * 1000) = TRUE AND l.driver.status = 'active'")
    List<Location> findNearbyLocations(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radiusKm") double radiusKm);
}
