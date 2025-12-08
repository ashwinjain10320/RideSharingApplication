package com.ridesharing;

import com.ridesharing.entities.*;

import java.util.Date;
import java.util.List;

public interface UserService {

    void createUser(String name, int age, Gender gender);

    User getUser(String name);

    Ride offerRide(String name, String origin, String destination, int seats, Vehicle vehicle, int duration, Date startTime);

    void addVehicle(String name, String vehicleNumber, String model);

    List<Ride> getRides(String origin, String destination);

    void acceptRide(String name, Ride ride);
}
