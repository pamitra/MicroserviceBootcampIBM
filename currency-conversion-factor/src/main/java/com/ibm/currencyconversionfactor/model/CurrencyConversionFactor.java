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
	
	private String country;
	
	private Double conFactor;
	
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getConFactor() {
		return conFactor;
	}

	public void setConFactor(double conFactor) {
		this.conFactor = conFactor;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
