package com.flightbookingapp.flightmanagement.service;

import java.sql.Date;
import java.util.List;

import com.flightbookingapp.commonservice.dto.FlightDTO;

public interface FlightService {
    
    public FlightDTO saveFlight(FlightDTO flightDTO);
    
    public FlightDTO getFlightById(String flightId);
    
    public List<FlightDTO> getAllFlights();
    
    public List<FlightDTO> getFlights(String source, String destination, Date flightDate);

}