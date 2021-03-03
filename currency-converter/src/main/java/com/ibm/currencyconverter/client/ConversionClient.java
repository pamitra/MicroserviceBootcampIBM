package com.ibm.currencyconverter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.JsonNode;

@FeignClient(name = "CONVERSIONFACTOR")
public interface ConversionClient {

	@GetMapping(value="/conversionFactor/{countryCode}" ,produces =  "*/*")
	public ResponseEntity<JsonNode> getConversionFactor(@PathVariable String countryCode);
	
}
