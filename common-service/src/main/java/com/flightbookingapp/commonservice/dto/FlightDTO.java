package com.flightbookingapp.commonservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.flightbookingapp.commonservice.enums.Airline;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

	private String flightId;
	private Airline airline;
    private String flightNumber;
    
    @NotEmpty(message = "Source is empty")
	@NotNull(message = "Please enter the source")
    private String source;
    
    @NotEmpty(message = "Destination is empty")
	@NotNull(message = "Please enter the destination")
    private String destination;
    
    @NotEmpty(message = "Date is empty")
	@NotNull(message = "Please enter the journey date")
    private LocalDate flightDate;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private BigDecimal price;
    
}