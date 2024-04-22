package com.flightbookingapp.flightmanagement.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingapp.flightmanagement.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
	
	Optional<List<Flight>> findBySourceAndDestinationAndFlightDate(String source, String destination, Date flightDate);
	
}
