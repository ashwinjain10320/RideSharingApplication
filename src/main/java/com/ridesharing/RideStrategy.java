package com.ridesharing;

import com.ridesharing.entities.Ride;

import java.util.List;

public interface RideStrategy {
     List<Ride> sortRidesBasedOnStrategy(List<Ride> rides);
}
