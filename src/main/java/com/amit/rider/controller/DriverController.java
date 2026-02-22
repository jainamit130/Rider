package com.amit.rider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @GetMapping("/ride/{rideId}/accept")
    public ResponseEntity<String> acceptRide(@PathVariable Long rideId) {
        return new ResponseEntity<>("Ride "+rideId+" accepted!", HttpStatus.OK);
    }

    @GetMapping("/ride/{rideId}/reject")
    public ResponseEntity<String> rejectRide(@PathVariable Long rideId) {
        return new ResponseEntity<>("Ride "+rideId+" rejected!", HttpStatus.OK);
    }
}
