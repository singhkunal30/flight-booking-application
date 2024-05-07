package com.flightbookingapp.commonservice.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
	
	private Long id;
    private Long userId;
    private String flightId;
    private LocalDate bookingDate;
    private Set<PassengerDTO> passengers;;

}
