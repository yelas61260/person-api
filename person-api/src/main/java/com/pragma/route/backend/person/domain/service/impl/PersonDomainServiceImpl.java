package com.pragma.route.backend.person.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.pragma.route.backend.person.domain.model.Person;
import com.pragma.route.backend.person.domain.service.PersonDomainService;
import com.pragma.route.backend.person.domain.service.validator.PersonValidatorDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonDomainServiceImpl implements PersonDomainService {
	
	private final PersonValidatorDomainService personValidatorDomainService;

	@Override
	public List<Person> processPersonListToRead(List<Person> persons) {
		return persons.stream().map(this::processPerson).collect(Collectors.toList());
	}
	
	@Override
	public List<Person> processPersonListToWrite(List<Person> persons) {
		return persons.stream().map(person -> {
			writeValidation(person);
			return person;
		}).collect(Collectors.toList());
	}

	@Override
	public Person processPerson(Person person) {
		Person personResponse = person.clone();
		personValidatorDomainService.validateEntityFormat(personResponse);
		return personResponse;
	}

	@Override
	public Person prepareToCreate(Person person) {
		Person personResponse = person.clone();
		writeValidation(personResponse);
		return personResponse;
	}

	@Override
	public Person prepareToUpdate(Person person) {
		Person personResponse = person.clone();
		writeValidation(personResponse);
		return personResponse;
	}
	
	private void writeValidation(Person person) {
		personValidatorDomainService.validateEntityRequired(person);
		personValidatorDomainService.validateEntityFormat(person);
	}

}
