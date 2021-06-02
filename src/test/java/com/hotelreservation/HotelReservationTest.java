package com.hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HotelReservationTest {
    @Test
    public void givenHotel_whenInvokeAddHotel_shoulBeAbleToAdd() {
        HotelReservationServices hotelReservationService = new HotelReservationServices();
        Hotel hotel = new Hotel("Lakewood",110);
        hotelReservationService.addHotel(hotel);
        List hotelList = hotelReservationService.getHotels();
        Assertions.assertTrue(hotelList.contains(hotel));
    }
}
