package com.flightbookingapp.flightmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flightbookingapp.commonservice.dto.FlightDTO;
import com.flightbookingapp.commonservice.utils.JsonUtils;
import com.flightbookingapp.flightmanagement.service.FlightService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/save")
	public ResponseEntity<FlightDTO> saveFlight(HttpServletRequest request){
		FlightDTO flightDTO = JsonUtils.bindRequestToObject(request, new TypeReference<FlightDTO>() {});
		return new ResponseEntity<FlightDTO>(flightService.saveFlight(flightDTO), HttpStatus.CREATED);
	}
	 
	@GetMapping("/{flightId}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable String flightId) {
		return new ResponseEntity<FlightDTO>(flightService.getFlightById(flightId), HttpStatus.OK);
	}
	
	@GetMapping("/flight/all")
	public ResponseEntity<List<FlightDTO>> getAllFlights(){
		return new ResponseEntity<List<FlightDTO>>(flightService.getAllFlights(), HttpStatus.OK);
	}
	@GetMapping("/flight/{source}-{destination}/{flightDate}")
	public ResponseEntity<List<FlightDTO>> getFlights(@PathVariable String source,@PathVariable String destination,
			@PathVariable LocalDate flightDate){
		return new ResponseEntity<List<FlightDTO>>(flightService.getFlights(source, destination, flightDate), 
				HttpStatus.OK);
	}

}
