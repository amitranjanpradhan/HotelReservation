package com.hotelreservation;

public class Hotel {
    public String hotelName;
    public int dailyRate;
    public Hotel(String hotelName, int dailyRate) {
        this.hotelName = hotelName;
        this.dailyRate = dailyRate;
    }
    public String toString() {
        return "Hotel: " + hotelName + "  Rate: " + dailyRate;
    }
    public String getName() {
        return hotelName;
    }
    public void setName(String name) {
        this.hotelName = hotelName;
    }
    public void setRate(int noOfDays) {
        this.dailyRate = this.dailyRate*noOfDays;
    }
    public int getRate() {
        return dailyRate;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }
}