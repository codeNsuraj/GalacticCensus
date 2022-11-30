package com.GalacticCensus.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.GalacticCensus.entity.Person;
import com.GalacticCensus.enums.Gender;
import com.GalacticCensus.repo.PersonRepo;

@SpringBootTest
public class PersonServiceTest {
	
	
	@Autowired
	private PersonService service;
	
	@Autowired
	private PersonRepo repo;
	
	@AfterEach
	public void Delete() {
		repo.get().clear();
	}
	
	@Test
	public void testGetAverageIncome1() {
		Person p1 = new Person();
		p1.setAnnualIncome(100000l);
		p1.setDateOfBirth(LocalDate.now());
		p1.setFullName("John Wick");
		p1.setGender(Gender.MALE.toString());
		p1.setLocalAddress("USA");
		p1.setPlanet("Earth");
		repo.add(p1);
		
		Person p2 = new Person();
		p2.setAnnualIncome(500000l);
		p2.setDateOfBirth(LocalDate.now());
		p2.setFullName("John Wick");
		p2.setGender(Gender.MALE.toString());
		p2.setLocalAddress("USA");
		p2.setPlanet("Earth");
		repo.add(p2);
		
		long income = service.getAverageIncome();
		
		assertThat(income).isEqualTo(300000l);
		
	}
	
	@Test
	public void testGetAverageIncome2() {
		
		Person p1 = new Person();
		p1.setAnnualIncome(10000000l);
		p1.setDateOfBirth(LocalDate.now());
		p1.setFullName("John Wick");
		p1.setGender(Gender.MALE.toString());
		p1.setLocalAddress("USA");
		p1.setPlanet("Earth");
		repo.add(p1);
		
		Person p2 = new Person();
		p2.setAnnualIncome(50000000l);
		p2.setDateOfBirth(LocalDate.now());
		p2.setFullName("John Wick");
		p2.setGender(Gender.MALE.toString());
		p2.setLocalAddress("USA");
		p2.setPlanet("Marse");
		repo.add(p2);
		
		Person p3 = new Person();
		p3.setAnnualIncome(10000000l);
		p3.setDateOfBirth(LocalDate.now());
		p3.setFullName("John Wick");
		p3.setGender(Gender.MALE.toString());
		p3.setLocalAddress("USA");
		p3.setPlanet("Earth");
		repo.add(p3);
		
		long income = service.getAverageIncome("Earth");
		
		assertThat(income).isEqualTo(10000000l);

	}

	@Test
	public void testGetPast10YearPersons() {
		
		Person p1 = new Person();
		p1.setAnnualIncome(10000000l);
		p1.setDateOfBirth(LocalDate.now());
		p1.setFullName("John Wick");
		p1.setGender(Gender.MALE.toString());
		p1.setLocalAddress("USA");
		p1.setPlanet("Earth");
		repo.add(p1);
		
		Person p2 = new Person();
		p2.setAnnualIncome(50000000l);
		p2.setDateOfBirth(LocalDate.now().minusYears(18));
		p2.setFullName("John Wick");
		p2.setGender(Gender.MALE.toString());
		p2.setLocalAddress("USA");
		p2.setPlanet("Mars");
		repo.add(p2);
		
		Person p3 = new Person();
		p3.setAnnualIncome(10000000l);
		p3.setDateOfBirth(LocalDate.now());
		p3.setFullName("John Wick");
		p3.setGender(Gender.MALE.toString());
		p3.setLocalAddress("USA");
		p3.setPlanet("Earth");
		repo.add(p3);
		
		long count = service.getPast10YearPersons().stream().count();
		
		assertThat(count).isEqualTo(2);
	
	}
	
	@Test
	public void testGetAll(){
		
		Person p1 = new Person();
		p1.setAnnualIncome(10000000l);
		p1.setDateOfBirth(LocalDate.now());
		p1.setFullName("John Wick");
		p1.setGender(Gender.MALE.toString());
		p1.setLocalAddress("USA");
		p1.setPlanet("Earth");
		repo.add(p1);
		
		Person p2 = new Person();
		p2.setAnnualIncome(50000000l);
		p2.setDateOfBirth(LocalDate.now().minusYears(18));
		p2.setFullName("John Wick");
		p2.setGender(Gender.MALE.toString());
		p2.setLocalAddress("USA");
		p2.setPlanet("Mars");
		repo.add(p2);
		
		Person p3 = new Person();
		p3.setAnnualIncome(10000000l);
		p3.setDateOfBirth(LocalDate.now());
		p3.setFullName("John Wick");
		p3.setGender(Gender.MALE.toString());
		p3.setLocalAddress("USA");
		p3.setPlanet("Earth");
		repo.add(p3);
		
		long count = service.getAll().keySet().stream().count();
		
		assertThat(count).isEqualTo(2);

	}

}
