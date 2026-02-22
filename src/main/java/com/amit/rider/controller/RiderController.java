package com.amit.rider.controller;

import com.amit.rider.entities.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
public class RiderController {

    // rider requests rides => payload (start and end location)
    @GetMapping("/ride/request")
    public ResponseEntity<String> rideRequest(Location startLocation, Location endLocation) {
        return new ResponseEntity<String>("Requested....Searching!!!", HttpStatus.OK);
    }


    
}
