package com.ridesharing.service;

import com.ridesharing.RideService;
import com.ridesharing.UserService;
import com.ridesharing.dal.UserDAL;
import com.ridesharing.entities.*;
import com.ridesharing.exception.VehicleNotOwnedByUserException;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAL userDAL;
    private RideService rideService;

    public UserServiceImpl(UserDAL userDAL, RideService rideService) {
        this.userDAL = userDAL;
        this.rideService = rideService;
    }

    @Override
    public void createUser(String name, int age, Gender gender) {
        userDAL.createUser(name, age, gender);
    }

    @Override
    public User getUser(String name) {
        return userDAL.getUser(name);
    }

    @Override
    public Ride offerRide(String name, String origin, String destination, int seats, Vehicle vehicle, int duration, Date startTime) {
        User user = getUser(name);
        isDriverOwningVehicle(user, vehicle);
        Ride ride = rideService.offerRide(name, origin, destination, seats, vehicle, duration, startTime);
        user.addRide(ride);
        user.addTotalRidesOffered();
        return ride;
    }

    @Override
    public void addVehicle(String name, String vehicleNumber, String model) {
        User user = getUser(name);
        user.addVehicle(new Vehicle(model, vehicleNumber));
    }

    @Override
    public List<Ride> getRides(String origin, String destination) {
        return rideService.fetchRidesBasedOnStrategy(origin, destination);
    }

    @Override
    public void acceptRide(String name, Ride ride) {
        User passengerName = getUser(name);
        User driverName = getUser(ride.getDriverName());
        rideService.validateRide(ride);
        passengerName.addTotalRidesTaken();
        driverName.addTotalRidesTaken();
        passengerName.addFuelSaved(ride.getDuration());
    }

    private void isDriverOwningVehicle(User user, Vehicle vehicle) {
        if(!user.getVehicles().contains(vehicle)) {
            throw new VehicleNotOwnedByUserException("vehicle is not owned by driver");
        }
    }
}
