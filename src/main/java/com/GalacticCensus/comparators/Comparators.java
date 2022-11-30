package com.GalacticCensus.comparators;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.GalacticCensus.entity.Person;

@Component
public class Comparators {

	public static class Comparator1 implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getFullName().compareTo(o2.getFullName());
		}

	}

}
