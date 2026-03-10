package com.amit.rider.repository;

import com.amit.rider.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Custom query to find locations by driver ID
    Location findFirstByDriverIdOrderByCreatedAtDesc(Long driverId);

    // Spatial query to find nearby locations
    // This would require a custom implementation with @Query annotation
}
