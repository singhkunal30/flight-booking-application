package com.flightbookingapp.flightmanagement.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.flightbookingapp.commonservice.enums.Airline;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {
    
	@Id
    @SequenceGenerator(name = "flight_id_seq", sequenceName = "flight_id_sequence", allocationSize = 1, initialValue = 1001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_id_seq")
	private String flightId;
    private Airline airline;
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal price;
    private int availableSeats;
    
}
