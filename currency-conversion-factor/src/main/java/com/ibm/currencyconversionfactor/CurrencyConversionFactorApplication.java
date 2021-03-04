package com.ibm.currencyconversionfactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CurrencyConversionFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionFactorApplication.class, args);
	}

}
