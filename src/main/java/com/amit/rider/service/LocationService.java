package com.amit.rider.service;

import com.amit.rider.entities.Driver;
import com.amit.rider.model.Location;
import com.amit.rider.repository.DriverRepository;
import com.amit.rider.repository.LocationRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final DriverRepository driverRepository;

    public LocationService(LocationRepository locationRepository, DriverRepository driverRepository) {
        this.locationRepository = locationRepository;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public void saveLocation(Long driverId, Location location) {
        // Ensure driver exists
        Driver driver = driverRepository.findByDriverId(driverId);
        if (driver == null) {
            driver = createDriver(driverId);
        }

        // Convert latitude/longitude to PostGIS Point geometry
        Point point = createPoint(location.getLatitude(), location.getLongitude());
        location.setLocation(point);
        location.setName("Driver " + driverId);

        // Associate location with driver
        location.setDriver(driver);

        // Save the location
        locationRepository.save(location);

        // Update current location in driver entity
        driver.setCurrentLocation(location);
        driverRepository.save(driver);
    }

    private Driver createDriver(Long driverId) {
        Driver driver = new Driver();
        driver.setDriverId(driverId);
        driver.setName("Driver " + driverId);
        driver.setStatus("active");
        return driverRepository.save(driver);
    }

    private Point createPoint(double latitude, double longitude) {
        // Create a Point geometry with SRID 4326 (WGS84)
        Point point = new GeometryFactory().createPoint(new Coordinate(longitude, latitude));
        point.setSRID(4326);
        return point;
    }
}