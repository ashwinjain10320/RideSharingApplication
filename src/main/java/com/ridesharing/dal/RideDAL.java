package com.ridesharing.dal;

import com.ridesharing.entities.Ride;
import com.ridesharing.entities.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ridesharing.entities.RideStatus.AVAILABLE;

public class RideDAL {
    private final List<Ride> rideDetails;

    public RideDAL() {
        this.rideDetails = new ArrayList<>();
    }

    public Ride createRide(String driverName, String origin, String destination, int seats, Vehicle vehicle, int duration, Date startTime) {
        Ride newRide = new Ride(driverName, origin, destination, vehicle, seats, duration, startTime);
        rideDetails.add(newRide);
        return newRide;
    }

    public List<Ride> fetchAllRides() {
        return rideDetails.stream().filter(ride -> ride.getRideStatus().equals(AVAILABLE)).toList();
    }

    public List<Ride> getRides(String origin, String destination) {
        return rideDetails.stream().filter(ride -> ride.getOrigin().equals(origin)
                && ride.getDestination().equals(destination)).toList();
    }
}
