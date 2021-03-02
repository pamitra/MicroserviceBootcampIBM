package com.ibm.currencyconversionfactor.repository;

import org.springframework.stereotype.Repository;

import com.ibm.currencyconversionfactor.model.CurrencyConversionFactor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

@Repository
public interface ConversionRepository extends JpaRepository<CurrencyConversionFactor, Long>{

	 @Query("select cf from CurrencyConversionFactor cf where cf.countryCode = ?1")
	 CurrencyConversionFactor findBycountry(String countryCode);
	}	
	 
