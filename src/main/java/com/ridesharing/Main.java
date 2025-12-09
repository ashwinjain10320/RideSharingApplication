package com.ridesharing;

import com.ridesharing.dal.RideDAL;
import com.ridesharing.dal.UserDAL;
import com.ridesharing.entities.Gender;
import com.ridesharing.entities.Ride;
import com.ridesharing.service.EarliestRideStrategy;
import com.ridesharing.service.FastestRideStrategy;
import com.ridesharing.service.RideServiceImpl;
import com.ridesharing.service.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        RideService rideService = new RideServiceImpl(new RideDAL(), new EarliestRideStrategy());
        UserService userService = new UserServiceImpl(new UserDAL(), rideService);

        // test case # 1
        userService.createUser("Rohan", 36, Gender.MALE);
        userService.createUser("Shashank", 29, Gender.MALE);
        userService.createUser("Nandini", 29, Gender.FEMALE);
        userService.createUser("Shipra", 27, Gender.FEMALE);
        userService.createUser("Gaurav", 29, Gender.MALE);

        userService.addVehicle("Rohan", "KA-01-12345", "Swift");
        userService.addVehicle("Shashank", "TS-05-62395", "Baleno");
        userService.addVehicle("Shipra", "KA-05-41491", "Polo");
        userService.addVehicle("Shipra", "KA-12-12332", "Scooty");

        userService.offerRide("Rohan", "Hyderabad", "Bangalore", 1, userService.getUser("Rohan").getVehicles().get(0), 13, parseDate("25th Jan, 2019 08:00"));
        userService.offerRide("Shipra", "Bangalore", "Mysore", 1, userService.getUser("Shipra").getVehicles().get(1), 1, parseDate("29th Jan, 2019 18:00"));
        userService.offerRide("Shipra", "Bangalore", "Mysore", 2, userService.getUser("Shipra").getVehicles().get(0), 4, parseDate("30th Jan, 2019 18:00"));
        userService.offerRide("Shashank", "Hyderabad", "Bangalore", 2, userService.getUser("Shashank").getVehicles().get(0), 14, parseDate("27th Jan, 2019 10:00"));

        List<Ride> rides1 = userService.getRides("Bangalore", "Mysore");
        userService.acceptRide("Nandini", rides1.get(0));
        // userService.acceptRide("Gaurav", rides1.get(0));
        System.out.println(rides1.get(0) + " Accepted");
        List<Ride> rides2 = userService.getRides("Mumbai", "Bangalore");
        // userService.acceptRide("Shashank", rides2.get(0));
        List<Ride> rides3 = userService.getRides("Hyderabad", "Bangalore");
        userService.acceptRide("Rohan", rides3.get(0));
        System.out.println(rides3.get(0) + " Accepted");

        System.out.println(userService.getUser("Rohan").toString());
        System.out.println(userService.getUser("Shashank").toString());
        System.out.println(userService.getUser("Shipra").toString());

    }

    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd'th' MMM, yyyy HH:mm");
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + dateStr);
            return new Date(); // Return current date as fallback or handle error as needed
        }
    }
}
