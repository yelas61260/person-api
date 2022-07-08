package com.pragma.route.backend.person.application.service.impl;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDto;
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
	public List<PersonDto> processPersonListToRead(List<PersonDto> persons) {
		List<Person> personsBase = personWithDtoMapper.toEntityList(persons);
		personsBase = personDomainService.processPersonListToRead(personsBase);
		return personWithDtoMapper.toDtoList(personsBase);
	}
	
	@Override
	public List<PersonDto> processPersonListToWrite(List<PersonDto> persons) {
		List<Person> personsBase = personWithDtoMapper.toEntityList(persons);
		personsBase = personDomainService.processPersonListToWrite(personsBase);
		return personWithDtoMapper.toDtoList(personsBase);
	}

	@Override
	public PersonDto processPerson(PersonDto person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.processPerson(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

	@Override
	public PersonDto prepareToCreate(PersonDto person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.prepareToCreate(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

	@Override
	public PersonDto prepareToUpdate(PersonDto person) {
		Person personBase = personWithDtoMapper.toEntity(person);
		personBase = personDomainService.prepareToUpdate(personBase);
		return personWithDtoMapper.toDto(personBase);
	}

}
