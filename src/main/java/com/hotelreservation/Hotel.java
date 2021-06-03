package com.hotelreservation;

public class Hotel {
    public String hotelName;
    public int dailyRate, weekDayRate, weekEndRate;

    /**
     * this one is a parameterised constructor which will initiate the value.
     *
     * @param hotelName
     * @param dailyRate
     */
    public Hotel(String hotelName, int dailyRate) {
        this.hotelName = hotelName;
        this.dailyRate = dailyRate;
    }

    /**
     * here i have created one more parameterised constructor for testcase which will initialise weekday rate and weekEnd rate.
     *
     * @param hotelName
     * @param weekDayRate
     * @param weekEndRate
     */
    public Hotel(String hotelName, int weekDayRate, int weekEndRate) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }

    /**
     * this is a overridden method which will print hotelname,weekdayrate and weekEnd rate.
     *
     * @return
     */
    public String toString() {
        return "Hotel: " + hotelName + "Weekday Rate: " + weekDayRate + " & WeekEnd Rate: " + weekEndRate;
    }

    /**
     * here i have used setter and getter method to set name and rate and according to that will get the value.
     *
     * @return
     */
    public String getName() {
        return hotelName;
    }

    public void setName(String name) {
        this.hotelName = hotelName;
    }

    /**
     * this method will take the no.ofdays and then set the rate.
     *
     * @param noOfDays
     */
    public void setRate(int noOfDays) {
        this.dailyRate = this.dailyRate * noOfDays;
    }

    /**
     * @return total rate.
     */
    public int getRate() {
        return dailyRate;
    }

    /**
     * here i have added welcome message.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }
}