package com.amit.rider.controller;

import com.amit.rider.entities.Driver;
import com.amit.rider.model.Location;
import com.amit.rider.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {

    private final DriverService driverService;

    // rider requests rides => payload (start and end location)
    @GetMapping("/ride/request")
    public ResponseEntity<String> rideRequest(Location startLocation, Location endLocation) {
        return new ResponseEntity<String>("Requested....Searching!!!", HttpStatus.OK);
    }

    // Find nearby drivers
    @GetMapping("/drivers/nearby")
    public ResponseEntity<?> findNearbyDrivers(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "5.0") double radiusKm) {

        List<Driver> nearbyDrivers = driverService.findNearbyDrivers(latitude, longitude, radiusKm);
        return ResponseEntity.ok(nearbyDrivers);
    }
}
