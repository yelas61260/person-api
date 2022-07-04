package com.pragma.route.backend.person.application.service;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDTO;

public interface PersonService {
	
	public List<PersonDTO> processPersonListToRead(List<PersonDTO> persons);
	public List<PersonDTO> processPersonListToWrite(List<PersonDTO> persons);
	public PersonDTO processPerson(PersonDTO person);
	
	public PersonDTO prepareToCreate(PersonDTO person);
	public PersonDTO prepareToUpdate(PersonDTO person);

}
