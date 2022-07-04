package com.pragma.route.backend.person.domain.service;

import java.util.List;

import com.pragma.route.backend.person.domain.model.Person;

public interface PersonDomainService {
	
	public List<Person> processPersonListToRead(List<Person> persons);
	public List<Person> processPersonListToWrite(List<Person> persons);
	public Person processPerson(Person person);
	
	public Person prepareToCreate(Person person);
	public Person prepareToUpdate(Person person);

}
