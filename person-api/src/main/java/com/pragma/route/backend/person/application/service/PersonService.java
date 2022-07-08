package com.pragma.route.backend.person.application.service;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDto;

public interface PersonService {
	
	public List<PersonDto> processPersonListToRead(List<PersonDto> persons);
	public List<PersonDto> processPersonListToWrite(List<PersonDto> persons);
	public PersonDto processPerson(PersonDto person);
	
	public PersonDto prepareToCreate(PersonDto person);
	public PersonDto prepareToUpdate(PersonDto person);

}
