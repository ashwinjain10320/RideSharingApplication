package com.ridesharing.entities;

import static com.ridesharing.entities.AvailabilityStatus.AVAILABLE;

public class Vehicle {
    private String model;
    private String vehicleNumber;
    private AvailabilityStatus availabilityStatus;

    public Vehicle(String model, String vehicleNumber) {
        this.model = model;
        this.vehicleNumber = vehicleNumber;
        this.availabilityStatus = AVAILABLE;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return this.model + " " + this.vehicleNumber + " " + this.availabilityStatus;
    }
}
