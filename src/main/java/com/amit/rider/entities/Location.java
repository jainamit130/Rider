package com.amit.rider.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Location {
    private double latitude;
    private double longitude;
}
