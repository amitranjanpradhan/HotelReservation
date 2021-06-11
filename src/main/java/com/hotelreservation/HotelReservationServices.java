package com.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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
    /**
     * here i have taken the dates as YYYY-MM-DD format.
     * This method will count NoOfWeekEnds.
     * @param firstDate
     * @param lastDate
     * @return
     */
    public int NoOfWeekEnds(String firstDate,String lastDate) throws InvalidDateError {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        if(startDate.compareTo(endDate)<0){
            int saturday = 0;
            int sunday = 0;
            while (!startDate.isAfter(endDate)) {
                if (startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                    saturday++;
                else if (startDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                    sunday++;
                startDate = startDate.plusDays(1);
            }
            System.out.println("Saturday count=="+saturday);
            System.out.println("Sunday count=="+sunday);
            return saturday+sunday;
        }
        else {
            throw new InvalidDateError("Invalid date.....please Enter valid first date and last date\nfirstdate should be before than lastdate");
        }
    }
    /**
     * this method will take date range as parameter and check the cheapestRate by using min operation.
     * here the return type is an object of class Hotel through which this method can access the values.
     * @return cheapestRate(obj of Hotel).
     */
    public Hotel findCheapestHotelByTotalRate(String firstDate, String lastDate) throws InvalidDateError {
        int weekDaysCount = NoOfDays(firstDate, lastDate);
        int weekEndsCount = NoOfWeekEnds(firstDate, lastDate);
        hotelList.stream().map(p -> {p.setRate(weekDaysCount,weekEndsCount); return p.getRate(); }).collect(Collectors.toList());
        Hotel cheapestHotel =  hotelList.stream().min(Comparator.comparing(Hotel::getRate)).orElse(null);
        int cheapestRate = cheapestHotel.getTotalRate();
        Predicate<Hotel> minimum = elements -> elements.getTotalRate()==cheapestRate;
        List<Hotel> minimumRateHotelList = hotelList.stream().filter(minimum).collect(Collectors.toList());
        minimumRateHotelList.stream().forEach(System.out::println);
        return cheapestHotel;
    }

}
