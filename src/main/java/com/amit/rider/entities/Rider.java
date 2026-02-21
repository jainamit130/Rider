package com.amit.rider.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rider {
    @Id
    private Long riderId;
    private Long rideId;
    private String name;
}
