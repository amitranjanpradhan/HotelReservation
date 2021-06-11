package com.hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HotelReservationTest {
    @Test
    public void givenHotel_whenInvokeAddHotel_shouldBeAbleToAdd() {
        HotelReservationServices hotelReservationService = new HotelReservationServices();
        Hotel hotel = new Hotel("Lakewood", 110);
        hotelReservationService.addHotel(hotel);
        List hotelList = hotelReservationService.getHotels();
        Assertions.assertTrue(hotelList.contains(hotel));
    }

    /**
     * this test case will check the cheapestHotel from the list according to the days.
     */
    @Test
    public void shouldBeAbleToReturnCheapestHotel() throws InvalidDateError {
        HotelReservationServices hotelReservationService1 = new HotelReservationServices();
        Hotel Lakewood = new Hotel("Lakewood", 110);
        Hotel Bridgewood = new Hotel("Bridgewood", 160);
        Hotel RidgeWood = new Hotel("Ridgewood", 220);
        hotelReservationService1.addHotel(Lakewood);
        hotelReservationService1.addHotel(Bridgewood);
        hotelReservationService1.addHotel(RidgeWood);
        int Days = hotelReservationService1.NoOfDays("2020-09-10", "2020-09-11");
        Hotel result = hotelReservationService1.findCheapestHotel(Days);
        Assertions.assertEquals(Lakewood, result);
    }

    /**
     * This test case will check whether weekday rate and weekend rate added or not.
     */
    @Test
    public void givenHotel_with3Parameters_shouldBeAbleToAdd_WeekdayAndWeekEndRate() {
        HotelReservationServices hotelReservationService = new HotelReservationServices();
        Hotel Lakewood = new Hotel("Lakewood", 110, 90);
        Hotel Bridgewood = new Hotel("Bridgewood", 150, 50);
        Hotel Ridgewood = new Hotel("Ridgewood", 220, 150);
        hotelReservationService.addHotel(Lakewood);
        hotelReservationService.addHotel(Bridgewood);
        hotelReservationService.addHotel(Ridgewood);
        List hotelList = hotelReservationService.getHotels();
        Assertions.assertTrue(hotelList.contains(Lakewood));
        Assertions.assertTrue(hotelList.contains(Bridgewood));
        Assertions.assertTrue(hotelList.contains(Ridgewood));
    }

    /**
     * Here it'll check the cheapest hotel according to the weekEnd and weekdays rates.
     *
     * @throws InvalidDateError
     */
    @Test
    public void givenHotelWillCheck_CheapestRate_from_TotalRate() throws InvalidDateError {
        HotelReservationServices hotelReservationService = new HotelReservationServices();
        Hotel Lakewood = new Hotel("Lakewood", 110, 90);
        Hotel Bridgewood = new Hotel("Bridgewood", 150, 50);
        Hotel Ridgewood = new Hotel("Ridgewood", 220, 150);
        hotelReservationService.addHotel(Lakewood);
        hotelReservationService.addHotel(Bridgewood);
        hotelReservationService.addHotel(Ridgewood);
        Hotel cheapestHotel = hotelReservationService.findCheapestHotelByTotalRate("2020-09-11", "2020-09-12");
        Assertions.assertEquals(Lakewood, cheapestHotel);
    }
}