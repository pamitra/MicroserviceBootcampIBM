package com.ibm.currencyconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconverter.client.ConversionClient;
import com.ibm.currencyconverter.dto.ConversionDTO;

@RestController
@EnableFeignClients
public class CurrencyConverterController {
	
	@Autowired
	private ConversionClient conClient;
	
	@Autowired
	private ConversionDTO dto;
	
	@RequestMapping(path = "/converter/{countrycode}/{amount}", method = RequestMethod.GET)
	public ResponseEntity<Double> convertCurrency(@PathVariable String countrycode, @PathVariable Double amount){
		
		ResponseEntity<Double> respEntity = conClient.getConversionFactor(countrycode);
		Double conversionF = respEntity.getBody();
		Double convertedAmt = amount * conversionF;
		dto.setConvertedAmount(convertedAmt);
		return ResponseEntity.ok(dto.getConvertedAmount());
	}
	
}
