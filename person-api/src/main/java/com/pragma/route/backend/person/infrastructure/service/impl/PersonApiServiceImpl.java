package com.pragma.route.backend.person.infrastructure.service.impl;

import java.util.List;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.exception.notfound.CityNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.PersonNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.ProfileNotFoundException;
import com.pragma.route.backend.person.infrastructure.db.repository.CityRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.ProfileRepository;
import com.pragma.route.backend.person.infrastructure.service.PersonApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonApiServiceImpl implements PersonApiService {
	
	private final PersonRepository personRepository;
	private final CityRepository cityRepository;
	private final ProfileRepository profileRepository;
	private final PersonService personService;

	@Override
	public PersonDTO create(PersonDTO personDto) {
		PersonDTO personDtoResponse = personService.prepareToCreate(personDto);
		if (personDto.getCityId() != 0 && !cityRepository.exist(personDto.getCityId())) {
			throw new CityNotFoundException();
		}
		if (personDto.getProfileId() != 0 && !profileRepository.exist(personDto.getProfileId())) {
			throw new ProfileNotFoundException();
		}
		return personRepository.create(personDtoResponse);
	}

	@Override
	public PersonDTO update(PersonDTO personDto) {
		PersonDTO personDtoResponse = personService.prepareToUpdate(personDto);
		if (personDto.getCityId() != 0 && !cityRepository.exist(personDto.getCityId())) {
			throw new CityNotFoundException();
		}
		if (personDto.getProfileId() != 0 && !profileRepository.exist(personDto.getProfileId())) {
			throw new ProfileNotFoundException();
		}
		return personRepository.update(personDtoResponse);
	}

	@Override
	public List<PersonDTO> getAllPerson() {
		List<PersonDTO> personsDTO = personRepository.getAll();
		return personService.processPersonListToRead(personsDTO);
	}

	@Override
	public PersonDTO getPersonById(int personId) {
		PersonDTO personDtoResponse = personRepository.getById(personId);
		if (personDtoResponse == null) {
			throw new PersonNotFoundException();
		}
		return personService.processPerson(personDtoResponse);
	}

}
