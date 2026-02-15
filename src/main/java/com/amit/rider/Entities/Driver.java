package com.amit.rider.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id
    private Long driverId;
    private double latitude;
    private double longitude;
}
