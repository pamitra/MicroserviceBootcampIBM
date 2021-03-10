package com.ibm.currencyconverter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url ="http://169.57.99.2:30082",name = "CONVERSIONFACTOR")
public interface ConversionClient {

	@GetMapping(value="conversionFactor/currency-conversion/{countryCode}" ,produces =  "*/*")
	public ResponseEntity<Double> getConversionFactor(@PathVariable String countryCode);
	
}
