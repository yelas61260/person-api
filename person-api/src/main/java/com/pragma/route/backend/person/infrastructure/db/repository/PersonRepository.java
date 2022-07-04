package com.pragma.route.backend.person.infrastructure.db.repository;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDTO;

public interface PersonRepository {
	
	public List<PersonDTO> getAll();
	public PersonDTO getById(int personId);
	
	public PersonDTO create(PersonDTO person);
	public PersonDTO update(PersonDTO person);

}
