package com.ridesharing.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Gender gender;
    private int age;
    private int fuelSaved;
    private int totalRidesTaken;
    private int totalRidesOffered;
    private List<Vehicle> vehicles;
    private List<Ride> ridesOffered;

    public User(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.fuelSaved = 0;
        this.vehicles = new ArrayList<>();
        this.ridesOffered = new ArrayList<>();
        this.totalRidesTaken = 0;
        this.totalRidesOffered = 0;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getFuelSaved() {
        return fuelSaved;
    }

    public void addFuelSaved(int additionalFuelSaved) {
        this.fuelSaved+=additionalFuelSaved;
    }

    public int getTotalRidesTaken() {
        return totalRidesTaken;
    }

    public void addTotalRidesTaken() {
        this.totalRidesTaken++;
    }

    public int getTotalRidesOffered() {
        return totalRidesOffered;
    }

    public void addTotalRidesOffered() {
        this.totalRidesOffered++;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addRide(Ride ride) {
        this.ridesOffered.add(ride);
        addTotalRidesOffered();
    }

    @Override
    public String toString() {
        return this.name + " " + this.gender + " " + this.age + " " + this.fuelSaved + " " + this.totalRidesTaken + " " + this.totalRidesOffered + " " + this.vehicles + " " + this.ridesOffered;
    }
}
