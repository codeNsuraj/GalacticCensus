package com.GalacticCensus.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GalacticCensus.comparators.Comparators;
import com.GalacticCensus.entity.Person;
import com.GalacticCensus.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	PersonRepo repo;

	public long getAverageIncome() {
		return repo.getPersonsAllIncomeSum() / repo.getPersonsTotalCount();
	}

	public long getAverageIncome(String planet) {
		return repo.get().stream().filter(x -> x.getPlanet().equals(planet)).map(x -> x.getAnnualIncome())
				.mapToLong(Long::valueOf).sum() / repo.getPersonsPerPlanet(planet);
	}

	public List<Person> getPast10YearPersons() {
		return repo.get().stream().filter(x -> x.getDateOfBirth().isAfter(LocalDate.now().minusYears(10))).collect(Collectors.toList());
	}
	
	
	public HashMap<String, HashMap<String, TreeSet<Person>>> getAll(){
		
		Iterator<Person> iterator = repo.get().iterator();
		HashMap<String, HashMap<String, TreeSet<Person>>> planets = new HashMap<>();	
		
		while (iterator.hasNext()) {
			Person p = (Person) iterator.next();
			
			if (planets.keySet().contains(p.getPlanet())) {
				if (planets.get(p.getPlanet()).containsKey(p.getGender())) {
					planets.get(p.getPlanet()).get(p.getGender()).add(p);
				} else {
					TreeSet<Person> treeset = new TreeSet<>(new Comparators.Comparator1());
					treeset.add(p);
					planets.get(p.getPlanet()).put(p.getGender(), treeset);
				}
			} else {
				HashMap<String, TreeSet<Person>> hashMap = new HashMap<>();
				TreeSet<Person> treeset = new TreeSet<>(new Comparators.Comparator1());
				treeset.add(p);
				hashMap.put(p.getGender(), treeset);
				planets.put(p.getPlanet(), hashMap);
			}
			
		}
		return planets;	
	}

}
