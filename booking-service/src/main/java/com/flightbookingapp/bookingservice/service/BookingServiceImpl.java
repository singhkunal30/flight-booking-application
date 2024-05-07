package com.flightbookingapp.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.flightbookingapp.bookingservice.model.Booking;
import com.flightbookingapp.bookingservice.repository.BookingRepository;
import com.flightbookingapp.commonservice.dto.BookingDTO;
import com.flightbookingapp.commonservice.exception.CommonException;
import com.flightbookingapp.commonservice.utils.ErrorCode;
import com.flightbookingapp.commonservice.utils.ErrorMessage;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingReporsitory; 
	
	@Autowired
	ErrorMessage errMsg;

	@Autowired
	ErrorCode errCode;
	
	@Override
	public BookingDTO bookFlight(BookingDTO bookingDTO) {
		return new BookingDTO();
	}

	@Override
	public boolean cancelBooking(Long bookingId) {
		Booking booking = bookingReporsitory.findById(bookingId).orElseThrow(() -> 
				new CommonException(errMsg.getBookingNotFound()+ " "+bookingId, errCode.getBookingNotFound(), HttpStatus.NOT_FOUND));
		bookingReporsitory.delete(booking);
		return bookingReporsitory.findById(bookingId).isEmpty();
	}

}
