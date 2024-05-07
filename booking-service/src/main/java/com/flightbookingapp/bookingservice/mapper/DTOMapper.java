package com.flightbookingapp.bookingservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.flightbookingapp.bookingservice.model.Booking;
import com.flightbookingapp.commonservice.dto.BookingDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DTOMapper {
	
	Booking toBooking(BookingDTO bookingDTO);
	
	BookingDTO toBookingDTO(Booking booking);
	
	List<BookingDTO> toBookingDTOs(List<Booking> bookings);

	List<Booking> toBookings(List<BookingDTO> bookings);
}
