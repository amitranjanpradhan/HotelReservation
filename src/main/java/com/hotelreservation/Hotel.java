package com.hotelreservation;

public class Hotel {
    public String hotelName;
    public int dailyRate;
    public Hotel(String hotelName, int dailyRate) {
        this.hotelName = hotelName;
        this.dailyRate = dailyRate;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }
}