package com.ridesharing;

import com.ridesharing.dal.RideDAL;
import com.ridesharing.dal.UserDAL;
import com.ridesharing.entities.Gender;
import com.ridesharing.entities.Ride;
import com.ridesharing.service.FastestRideStrategy;
import com.ridesharing.service.RideServiceImpl;
import com.ridesharing.service.UserServiceImpl;

import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        RideService rideService = new RideServiceImpl(new RideDAL(), new FastestRideStrategy());
        UserService userService = new UserServiceImpl(new UserDAL(), rideService);

        userService.createUser("Ashwin", 22, Gender.MALE);
        userService.createUser("Ashwin2", 26, Gender.FEMALE);
        userService.createUser("Ashwin3", 25, Gender.MALE);

        System.out.println(userService.getUser("Ashwin2").toString());
        System.out.println(userService.getUser("Ashwin").toString());
        System.out.println(userService.getUser("Ashwin3").toString());

        userService.addVehicle("Ashwin", "12345", "23456");
        System.out.println(userService.getUser("Ashwin").toString());

        userService.offerRide("Ashwin", "Bengaluru", "Hyderabad", 1, userService.getUser("Ashwin").getVehicles().get(0), 10, new Date(987656765L));
        System.out.println(userService.getUser("Ashwin").toString());

        List<Ride> rides = userService.getRides("Bengaluru", "Hyderabad");
        System.out.println(rides);

        System.out.println(userService.getUser("Ashwin2").toString());
        System.out.println(userService.getUser("Ashwin").toString());
        userService.acceptRide("Ashwin3", rides.get(0));
    }
}
