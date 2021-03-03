package com.ibm.currencyconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.currencyconverter.client.ConversionClient;
import com.ibm.currencyconverter.dto.ConverstionDTO;

@RestController
@RequestMapping("/converter")
public class CurrencyConverterController {
	
	@Autowired
	private ConversionClient conClient;
	
	@GetMapping("/amountConversion")
	public ResponseEntity<JsonNode> convertCurrency(@RequestBody String countryCode, @RequestBody Double amount){
		ResponseEntity<JsonNode> conF = conClient.getConversionFactor(countryCode);
		JsonNode content = conF.getBody();
		Double conversionF = content.asDouble(1.00);
		Double convertedAmt = amount * conversionF;
		ObjectMapper mapper = new ObjectMapper(); 
		JsonNode node = mapper.convertValue(convertedAmt, JsonNode.class);
		return ResponseEntity.ok(node);
	}
	
}
