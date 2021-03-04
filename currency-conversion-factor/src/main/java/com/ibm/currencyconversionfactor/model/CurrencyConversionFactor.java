package com.ibm.currencyconversionfactor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CurrencyConversionFactor {

	@Id@GeneratedValue
	private long id;
	
	private String countryCode;
	
	private Double conFactor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountry(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getConFactor() {
		return conFactor;
	}

	public void setConFactor(double conFactor) {
		this.conFactor = conFactor;
	}








}
