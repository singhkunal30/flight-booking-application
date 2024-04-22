package com.flightbookingapp.flightmanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.flightbookingapp.commonservice.dto.FlightDTO;
import com.flightbookingapp.flightmanagement.model.Flight;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DTOMapper {
	
	Flight toFlight(FlightDTO flightDTO);
	
	FlightDTO toFlightDTO(Flight flight);
	
	List<FlightDTO> toFlightDTOs(List<Flight> flights);

	List<Flight> toFlights(List<FlightDTO> flights);
}
