package com.GalacticCensus.repo;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.GalacticCensus.entity.Person;

@Repository
public class PersonRepo {

	private List<Person> aliens = new ArrayList<>();

	public boolean add(Person p) {	
		return aliens.add(p);
	}
	
	public long getPersonsTotalCount() {
		return aliens.stream().count();
	}
	
	public long getPersonsPerPlanet(String planet) {
		return aliens.stream().filter(x->x.getPlanet().equals(planet)).count();	
	}
	
	public long getPersonsAllIncomeSum() {
		return aliens.stream().map(x->x.getAnnualIncome()).mapToLong(Long::valueOf).sum();
	}
	
	public List<Person> get() {
		return aliens;
	}
	
	public Person get(String name) {
		return aliens.stream().filter(x->x.getFullName().equals(name)).findFirst().get();
	}
}