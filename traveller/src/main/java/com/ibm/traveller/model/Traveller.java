package com.ibm.traveller.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Traveller {
	
	@Id
	private long id;
	private String firstName;
	private String lastName;

}
