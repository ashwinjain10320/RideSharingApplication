package com.ridesharing.dal;

import com.ridesharing.entities.Gender;
import com.ridesharing.entities.User;
import com.ridesharing.exception.InvalidUserException;

import java.util.HashMap;
import java.util.Map;

public class UserDAL {
    private final Map<String, User> userDetails;

    public UserDAL() {
        this.userDetails = new HashMap<>();
    }

    public void createUser(String name, int age, Gender gender) {
        User user = new User(name, gender, age);
        userDetails.put(name, user);
    }

    public User getUser(String name) {
        try {
            return userDetails.get(name);
        } catch (NullPointerException e) {
            System.out.println("User not found");
            throw new InvalidUserException("User is invalid");
        }
    }
}
