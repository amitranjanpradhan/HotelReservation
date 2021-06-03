package com.hotelreservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationServices {
    /**
     * here i have created an arraylist to store values of hotel name and rates.
     */
    public List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    /**
     * this method will return the values.
     *
     * @return
     */
    public List<Hotel> getHotels() {
        return hotelList;
    }
    /**
     * here i have taken the dates as YYYY-MM-DD format.
     * @param firstDate
     * @param lastDate
     * @return
     */
    public int NoOfDays(String firstDate,String lastDate) throws InvalidDateError {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        if(startDate.compareTo(endDate)<0){
            int noOfDays=(int) ChronoUnit.DAYS.between(startDate,endDate);
            return  noOfDays;
        }
        else {
            throw new InvalidDateError("Invalid date.....please Enter valid first date and last date\nfirstdate should be before than lastdate");
        }
    }
    /**
     * this method will take no of days as parameter and check the cheapestRate by using min operation.
     * here the return type is an object of class Hotel through which this method can access the values.
     * @param NoOfDays
     * @return cheapestRate(obj of Hotel).
     */
    public Hotel findCheapestHotel(int NoOfDays) {
        hotelList.stream().map(p -> {p.setRate(NoOfDays); return p.getRate(); }).collect(Collectors.toList());
        Hotel cheapestRate =  hotelList.stream().min(Comparator.comparing(Hotel::getRate)).orElse(null);
        return cheapestRate;
    }
}
