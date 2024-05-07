package com.flightbookingapp.flightmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private FlightService flightService;
	
	@PostMapping("/save")
	public ResponseEntity<FlightDTO> saveFlight(HttpServletRequest request){
		FlightDTO flightDTO = JsonUtils.bindRequestToObject(request, new TypeReference<FlightDTO>(){});
		return new ResponseEntity<FlightDTO>(flightService.saveFlight(flightDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{flightId}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable String flightId) {
		return new ResponseEntity<FlightDTO>(flightService.getFlightById(flightId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<FlightDTO>> getAllFlights(){
		return new ResponseEntity<List<FlightDTO>>(flightService.getAllFlights(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<FlightDTO>> getFlights(@RequestParam("source") String source, 
			@RequestParam("destination")String destination){
		return new ResponseEntity<List<FlightDTO>>(flightService.getFlights(source, destination), 
				HttpStatus.ACCEPTED);	
	}
}
