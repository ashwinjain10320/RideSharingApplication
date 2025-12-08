package com.ridesharing.service;

import com.ridesharing.RideService;
import com.ridesharing.RideStrategy;
import com.ridesharing.dal.RideDAL;
import com.ridesharing.entities.Ride;
import com.ridesharing.entities.RideStatus;
import com.ridesharing.entities.Vehicle;
import com.ridesharing.exception.RideOccupiedException;

import java.util.Date;
import java.util.List;

public class RideServiceImpl implements RideService {

    private RideDAL rideDAL;
    private RideStrategy rideStrategy;

    public RideServiceImpl(RideDAL rideDAL, RideStrategy rideStrategy) {
        this.rideDAL = rideDAL;
        this.rideStrategy = rideStrategy;
    }

    @Override
    public List<Ride> fetchAllRides() {
        return rideDAL.fetchAllRides();
    }

    @Override
    public Ride offerRide(String name, String origin, String destination, int seats, Vehicle vehicle, int duration, Date startTime) {
        return rideDAL.createRide(name, origin, destination, seats, vehicle, duration, startTime);
    }

    @Override
    public List<Ride> fetchRidesBasedOnStrategy(String origin, String destination) {
        return rideStrategy.sortRidesBasedOnStrategy(fetchAllRides());
    }

    @Override
    public void validateRide(Ride ride) {
        if(ride.getSeats() == 0) {
            ride.setRideStatus(RideStatus.OCCUPIED);
            throw new RideOccupiedException("Ride is already full");
        }
        ride.setSeats(ride.getSeats() - 1);
    }
}
