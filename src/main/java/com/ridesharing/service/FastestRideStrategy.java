package com.ridesharing.service;

import com.ridesharing.RideStrategy;
import com.ridesharing.entities.Ride;

import java.util.Comparator;
import java.util.List;

public class FastestRideStrategy implements RideStrategy {

    @Override
    public List<Ride> sortRidesBasedOnStrategy(List<Ride> rides) {
        return rides.stream().sorted(Comparator.comparing(Ride::getDuration)).toList();
    }
}
