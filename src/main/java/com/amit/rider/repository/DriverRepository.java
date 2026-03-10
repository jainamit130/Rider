package com.amit.rider.repository;

import com.amit.rider.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByDriverId(Long driverId);

    boolean existsByDriverId(Long driverId);
}
