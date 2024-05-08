package com.flightbookingapp.flightmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbookingapp.commonservice.dto.FlightDTO;
import com.flightbookingapp.commonservice.exception.CommonException;
import com.flightbookingapp.flightmanagement.mapper.DTOMapper;
import com.flightbookingapp.flightmanagement.model.Flight;
import com.flightbookingapp.flightmanagement.repository.FlightRepository;

@Service
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
				.orElseThrow(() -> new CommonException(flightId, null, null));
		return mapper.toFlightDTO(flight);
	}

	@Override
	public List<FlightDTO> getAllFlights() {
		return mapper.toFlightDTOs(flightRepository.findAll());
	}

	@Override
	public List<FlightDTO> getFlights(String source, String destination) {
		return mapper.toFlightDTOs(flightRepository.findBySourceAndDestination(source, destination).get());
	}

}
