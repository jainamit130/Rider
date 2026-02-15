package com.amit.rider.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideId;
    private Long passengerId;
    private Long driverId;
    private LocalDateTime creationTimeStamp;
    private Location startLocation;
    private Location endLocation;
    private RideStatus rideStatus;
}
