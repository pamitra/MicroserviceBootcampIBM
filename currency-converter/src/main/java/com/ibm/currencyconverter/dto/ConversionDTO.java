package com.ibm.currencyconverter.dto;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class ConversionDTO {

	private String countryCode;
	
	private Double conFactor;
	
	private Double amountToConvert;
	
	private double convertedAmount;
	
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

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public Double getAmountToConvert() {
		return amountToConvert;
	}

	public void setAmountToConvert(Double amountToConvert) {
		this.amountToConvert = amountToConvert;
	}
}
