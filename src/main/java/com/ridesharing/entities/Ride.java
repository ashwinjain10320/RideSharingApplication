package com.ridesharing.entities;

import java.util.Date;

public class Ride {
    private String driverName;
    private String origin;
    private String destination;
    private int seats;
    private Vehicle vehicle;
    private int duration;
    private Date startTime;
    private RideStatus rideStatus;

    public Ride(String driverName, String origin, String destination, Vehicle vehicle, int seats, int duration, Date startTime) {
        this.origin = origin;
        this.destination = destination;
        this.vehicle = vehicle;
        this.seats = seats;
        this.duration = duration;
        this.startTime = startTime;
        this.rideStatus = RideStatus.AVAILABLE;
        this.driverName = driverName;
    }

    public String getOrigin() {
        return origin;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDuration() {
        return duration;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return this.origin + " " + this.destination + " " + this.vehicle + " " + this.seats + " " + this.duration + " " + this.startTime + " " + this.rideStatus + " " + this.driverName;
    }
}
