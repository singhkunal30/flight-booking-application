package com.flightbookingapp.flightmanagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class FlightExecption extends RuntimeException{
	
	private final LocalDateTime timestamp;
	private final String errMsg;
	private final Long errCode;
	private final HttpStatus httpStatus;
	
	public FlightExecption(String errMsg, Long errCode, HttpStatus httpStatus) {
		this.timestamp = LocalDateTime.now();
		this.errMsg = errMsg;
		this.errCode = errCode;
		this.httpStatus = httpStatus;
	}

}
