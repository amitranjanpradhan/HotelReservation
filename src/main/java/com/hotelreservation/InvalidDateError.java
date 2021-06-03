package com.hotelreservation;

public class InvalidDateError extends Throwable {
    public InvalidDateError(String message){
        super(message);
    }
}
