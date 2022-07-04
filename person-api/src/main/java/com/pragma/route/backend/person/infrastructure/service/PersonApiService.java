package com.pragma.route.backend.person.infrastructure.service;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDTO;

public interface PersonApiService {
	
	public PersonDTO create(PersonDTO person);
	public PersonDTO update(PersonDTO person);
    public List<PersonDTO> getAllPerson();
    public PersonDTO getPersonById(int personId);

}
