package com.ibm.currencyconverter.dto;

public class ConverstionDTO {

	private String countryCode;
	
	private Double conFactor;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getConFactor() {
		return conFactor;
	}

	public void setConFactor(Double conFactor) {
		this.conFactor = conFactor;
	}
}
