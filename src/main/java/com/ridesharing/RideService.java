package com.ridesharing;

import com.ridesharing.entities.Ride;
import com.ridesharing.entities.Vehicle;

import java.util.Date;
import java.util.List;

public interface RideService {

    List<Ride> fetchAllRides();

    Ride offerRide(String name, String origin, String destination, int seats, Vehicle vehicle, int duration, Date startTime);

    List<Ride> fetchRidesBasedOnStrategy(String origin, String destination);

    void validateRide(Ride ride);
}
