package com.flightbookingapp.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flightbookingapp.bookingservice.service.BookingService;
import com.flightbookingapp.commonservice.dto.BookingDTO;
import com.flightbookingapp.commonservice.utils.JsonUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<BookingDTO> bookFlight(HttpServletRequest request){
		BookingDTO bookingDTO = JsonUtils.bindRequestToObject(request, new TypeReference<BookingDTO>() {});
		return new ResponseEntity<BookingDTO>(bookingService.bookFlight(bookingDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancel/{bookingId}")
	public ResponseEntity<Boolean> cancelBooking(@PathVariable Long bookingId){
		return new ResponseEntity<Boolean>(bookingService.cancelBooking(bookingId), HttpStatus.ACCEPTED);
	}
}
