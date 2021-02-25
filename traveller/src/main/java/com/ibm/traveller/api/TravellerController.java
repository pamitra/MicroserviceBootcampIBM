package com.ibm.traveller.api;

import com.ibm.traveller.repository.TravellerRepository;
import com.ibm.traveller.model.Traveller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/traveller")
public class TravellerController {
	
	@Autowired
	public TravellerRepository travellerRepository;
	
	@PostConstruct
	public void init() {
		Traveller traveller = new Traveller();
		traveller.setId(0);
		traveller.setFirstName("FirstName");
		traveller.setLastName("LastName");
		travellerRepository.save(traveller);
	}

	@GetMapping
	public ResponseEntity<List<Traveller>> getAll(){
		return ResponseEntity.ok(travellerRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Traveller> addTraveller(@RequestBody Traveller traveller){
		return ResponseEntity.ok(travellerRepository.save(traveller));
		
	}
}
