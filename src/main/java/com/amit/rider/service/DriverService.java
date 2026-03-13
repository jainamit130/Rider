package com.amit.rider.service;

import com.amit.rider.entities.Driver;
import com.amit.rider.model.Location;
import com.amit.rider.repository.DriverRepository;
import com.amit.rider.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final LocationRepository locationRepository;
    private final DriverRepository driverRepository;

    public DriverService(LocationRepository locationRepository, DriverRepository driverRepository) {
        this.locationRepository = locationRepository;
        this.driverRepository = driverRepository;
    }

    public List<Driver> findNearbyDrivers(double latitude, double longitude, double radiusKm) {
        // Find locations within the radius
        List<Location> nearbyLocations = locationRepository.findNearbyLocations(latitude, longitude, radiusKm);

        // Extract unique drivers from locations
        return nearbyLocations.stream()
                .map(Location::getDriver)
                .distinct()
                .toList();
    }
}
