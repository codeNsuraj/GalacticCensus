package com.GalacticCensus.entity;

import java.time.LocalDate;

public class Person {
	
	private String fullName;
	private LocalDate dateOfBirth;
	private String planet;
	private String Gender;
	private String LocalAddress;
	private Long AnnualIncome;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planetOfResidence) {
		this.planet = planetOfResidence;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getLocalAddress() {
		return LocalAddress;
	}
	public void setLocalAddress(String localAddress) {
		LocalAddress = localAddress;
	}
	public Long getAnnualIncome() {
		return AnnualIncome;
	}
	public void setAnnualIncome(Long i) {
		AnnualIncome = i;
	}
}
