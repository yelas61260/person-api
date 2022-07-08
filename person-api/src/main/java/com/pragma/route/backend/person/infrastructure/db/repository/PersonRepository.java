package com.pragma.route.backend.person.infrastructure.db.repository;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDto;

public interface PersonRepository {
	
	public List<PersonDto> getAll();
	public PersonDto getById(int personId);
	
	public PersonDto create(PersonDto person);
	public PersonDto update(PersonDto person);

}
