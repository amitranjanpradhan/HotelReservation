package com.hotelreservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationServices {
    public List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
        for (Hotel hotelDetails:hotelList) {
            System.out.println("Hotel name:"+hotelDetails.getName()+"Total rate: "+hotelDetails.getRate());
        }
    }

    public List<Hotel> getHotels() {
        return hotelList;
    }

    public int NoOfDays(String firstDate,String lastDate) {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        int noOfDays=(int) ChronoUnit.DAYS.between(startDate,endDate);
        return  noOfDays;
    }

    public Hotel findCheapestHotel(int NoOfDays) {
        hotelList.stream().map(p -> {p.setRate(NoOfDays);return p.getRate(); }).collect(Collectors.toList());
        Hotel cheapestRate =  hotelList.stream().min(Comparator.comparing(Hotel::getRate)).orElse(null);
        return cheapestRate;
    }
}
