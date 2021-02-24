package com.ibm.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.ibm.airline.client.TravellerClient;

@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	@Autowired
	private TravellerClient travellerClient;
	
	@GetMapping("/passangers")
	public ResponseEntity<JsonNode> getPassangers(){
		return travellerClient.getAll();
	}

}
