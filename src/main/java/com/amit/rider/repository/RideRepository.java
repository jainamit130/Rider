package com.amit.rider.repository;

import com.amit.rider.entities.Ride;
import com.amit.rider.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {
}
