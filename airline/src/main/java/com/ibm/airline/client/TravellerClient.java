package com.ibm.airline.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

@FeignClient(name = "TRAVELLER")
public interface TravellerClient {
	
	@RequestMapping(value="/traveller",method=RequestMethod.GET, produces = "*/*")
	public ResponseEntity<JsonNode> getAll();
}
