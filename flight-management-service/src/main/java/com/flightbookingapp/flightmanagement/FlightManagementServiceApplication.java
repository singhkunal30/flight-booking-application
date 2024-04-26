package com.flightbookingapp.flightmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.flightbookingapp.flightmanagement", "com.flightbookingapp.commonservice"})
public class FlightManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementServiceApplication.class, args);
	}

}
