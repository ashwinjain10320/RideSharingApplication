package com.ridesharing.exception;

public class VehicleNotOwnedByUserException extends RuntimeException {
    public VehicleNotOwnedByUserException(String message) {
        super(message);
    }
}
