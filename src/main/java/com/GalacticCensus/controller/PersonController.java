package com.GalacticCensus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GalacticCensus.entity.Person;
import com.GalacticCensus.repo.PersonRepo;
import com.GalacticCensus.service.PersonService;

@RestController
@RequestMapping("/galaxy")
public class PersonController {
	
	@Autowired
	private PersonRepo repo;
	
	@Autowired
	private PersonService service;
	
	@GetMapping("/total")
	public ResponseEntity<?> total(){		
		return ResponseEntity.status(HttpStatus.OK).body(repo.getPersonsTotalCount());
	}
	
	@GetMapping("/total/{p}")
	public ResponseEntity<?> total(@PathVariable("p") String planet){
		return ResponseEntity.status(HttpStatus.OK).body(repo.getPersonsPerPlanet(planet));
	}
	
	@GetMapping("/income")
	public ResponseEntity<?> income(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAverageIncome());
	}
	
	@GetMapping("/income/{p}")
	public ResponseEntity<?> income(@PathVariable("p") String planet){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAverageIncome(planet));
	}
	
	@GetMapping("/get10yearold")
	public ResponseEntity<?> getPerson(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getPast10YearPersons());
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@GetMapping("/get/{p}")
	public ResponseEntity<?> getPerson(@PathVariable("p") String name){
		return ResponseEntity.status(HttpStatus.OK).body(repo.get(name));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savePerson(@RequestBody Person p){
		return ResponseEntity.status(HttpStatus.OK).body(repo.add(p));
	}
	
}
