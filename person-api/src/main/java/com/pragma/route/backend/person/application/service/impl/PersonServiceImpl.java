package com.pragma.route.backend.person.application.service.impl;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.application.mapper.PersonWithDtoMapper;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.model.Person;
import com.pragma.route.backend.person.domain.service.PersonDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
	
	private PersonDomainService personDomainService;
	private PersonWithDtoMapper personWithDtoMapper;
	
	@Override
	public List<PersonDTO> processPersonListToRead(List<PersonDTO> persons) {
		List<Person> personsBase = personWithDtoMapper.toEntityList(persons);
		personsBase = personDomainService.processPersonListToRead(personsBase);
		return personWithDtoMapper.toDtoList(personsBase);
	}
	
	@Override
	public List<PersonDTO> processPersonListToWrite(List<PersonDTO> persons) {
		List<Person> personsBase = personWithDtoMapper.toEntityList(persons);
		personsBase = personDomainService.processPersonListToWrite(personsBase);
		return personWithDtoMapper.toDtoList(personsBase);
	}

	@Override
	public PersonDTO processPerson(PersonDTO person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.processPerson(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

	@Override
	public PersonDTO prepareToCreate(PersonDTO person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.prepareToCreate(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

	@Override
	public PersonDTO prepareToUpdate(PersonDTO person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.prepareToUpdate(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

}
