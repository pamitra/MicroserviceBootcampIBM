package com.ibm.currencyconversionfactor.api;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconversionfactor.model.CurrencyConversionFactor;
import com.ibm.currencyconversionfactor.repository.ConversionRepository;

@RestController
@RequestMapping(path="/conversion")
public class CurrencyConversionController {
	
	@Autowired
	private ConversionRepository conversionRepo;

	
	@PostConstruct
	public void init() {
		CurrencyConversionFactor conversionF = new CurrencyConversionFactor();
		conversionF.setCountry("india");
		conversionF.setConFactor(70.00);
		conversionRepo.save(conversionF);
	}
	
	@GetMapping
	public ResponseEntity<List<CurrencyConversionFactor>> getAll() {
		return ResponseEntity.ok(conversionRepo.findAll());
	}
	
	@GetMapping("/currency-conversion/{countrycode}")
	public ResponseEntity<Double> getConversionFactor(@PathVariable String countrycode)
	{
//		ResponseEntity<CurrencyConversionFactor> ccf = ResponseEntity.ok(conversionRepo.findBycountry(country));
		CurrencyConversionFactor currencyConversionFactor = conversionRepo.findBycountry(countrycode);
		ResponseEntity<Double> convFact = ResponseEntity.ok(currencyConversionFactor.getConFactor());
		return convFact;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK, reason = "conversion factor added")
	public ResponseEntity<List<CurrencyConversionFactor>> addConversionFactor(@RequestBody List<CurrencyConversionFactor> conFactrs){
		return ResponseEntity.ok(conversionRepo.saveAll(conFactrs));
		
	}
	
	  @PutMapping
	  @ResponseStatus(value = HttpStatus.OK, reason = "conversion factor updated")
//	  public ResponseEntity<CurrencyConversionFactor> updateConversionFactor(@RequestBody String ccf, @RequestBody String country) {
	  public ResponseEntity<CurrencyConversionFactor> updateConversionFactor(@RequestBody CurrencyConversionFactor conFactr ){
		  String country = conFactr.getCountryCode();
		  Double conF = conFactr.getConFactor();
//		  Double conF = Double.parseDouble(conFactr);
		  CurrencyConversionFactor currencyConversionFactor = conversionRepo.findBycountry(country);
		  if (currencyConversionFactor.getConFactor()!=conF) {
			currencyConversionFactor.setCountry(country);
			currencyConversionFactor.setConFactor(conF);
			return ResponseEntity.ok(conversionRepo.save(currencyConversionFactor));
		  }else {
//			  currencyConversionFactor.setMessage("country and conversionFactor combination already exists !! ");
			  return ResponseEntity.ok(conversionRepo.findBycountry(country));
		  }

	  }

}
