package com.amit.rider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import com.amit.rider.dto.LocationUpdateDTO;
import com.amit.rider.model.Location;
import com.amit.rider.service.LocationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final LocationService locationService;

    @GetMapping("/ride/{rideId}/accept")
    public ResponseEntity<String> acceptRide(@PathVariable Long rideId) {
        return new ResponseEntity<>("Ride "+rideId+" accepted!", HttpStatus.OK);
    }

    @GetMapping("/ride/{rideId}/reject")
    public ResponseEntity<String> rejectRide(@PathVariable Long rideId) {
        return new ResponseEntity<>("Ride "+rideId+" rejected!", HttpStatus.OK);
    }

//    @MessageMapping("/location/update/{driverId}")
//    @SendTo("/topic/location")
    @PostMapping("/location/update/{driverId}")
    public String updateLocation(@PathVariable Long driverId, @RequestBody LocationUpdateDTO locationUpdate) {
        // Convert DTO to Location entity
        Location location = new Location();
        location.setLatitude(locationUpdate.getLatitude());
        location.setLongitude(locationUpdate.getLongitude());

        locationService.saveLocation(driverId, location);
        return "Driver location updated!";
    }
}
