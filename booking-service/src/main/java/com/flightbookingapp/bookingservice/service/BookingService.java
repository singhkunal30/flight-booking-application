package com.flightbookingapp.bookingservice.service;

import com.flightbookingapp.commonservice.dto.BookingDTO;

public interface BookingService {
	
    public BookingDTO bookFlight(BookingDTO bookingDTO);

    public boolean cancelBooking(Long bookingId);
}
