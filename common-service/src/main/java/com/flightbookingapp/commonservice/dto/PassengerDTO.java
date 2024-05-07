package com.flightbookingapp.commonservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
	
	private Long id;
    private String name;
    private int age;
    private Long bookingId;
}
