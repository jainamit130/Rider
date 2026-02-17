package com.amit.rider.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rider {
    private Long riderId;
    private Long rideId;
    private String name;
}
