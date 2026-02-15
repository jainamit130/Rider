package com.amit.rider.Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rider {
    private Long riderId;
    private Long rideId;
}
