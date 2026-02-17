package com.amit.rider.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id
    private Long driverId;
    private double latitude;
    private double longitude;
}
