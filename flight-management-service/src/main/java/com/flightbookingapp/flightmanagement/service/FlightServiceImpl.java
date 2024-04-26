package com.flightbookingapp.flightmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightbookingapp.commonservice.dto.FlightDTO;
import com.flightbookingapp.flightmanagement.exception.FlightExecption;
import com.flightbookingapp.flightmanagement.mapper.DTOMapper;
import com.flightbookingapp.flightmanagement.model.Flight;
import com.flightbookingapp.flightmanagement.repository.FlightRepository;

public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private DTOMapper mapper;
	
	@Override
	public FlightDTO saveFlight(FlightDTO flightDTO) {
		Flight flight = mapper.toFlight(flightDTO);
		Flight savedFlight = flightRepository.save(flight);
		return mapper.toFlightDTO(savedFlight);
	}

	@Override
	public FlightDTO getFlightById(String flightId) {
		Flight flight = flightRepository.findById(flightId)
				.orElseThrow(() -> new FlightExecption(flightId, null, null));
		return mapper.toFlightDTO(flight);
	}

	@Override
	public List<FlightDTO> getAllFlights() {
		return mapper.toFlightDTOs(flightRepository.findAll());
	}

	@Override
	public List<FlightDTO> getFlights(String source, String destination, LocalDate flightDate) {
		return mapper.toFlightDTOs(flightRepository.
				findBySourceAndDestinationAndFlightDate(source, destination, flightDate).get());
	}

}
