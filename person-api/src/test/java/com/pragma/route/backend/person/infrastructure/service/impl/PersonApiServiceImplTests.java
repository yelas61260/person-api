package com.pragma.route.backend.person.infrastructure.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.exception.notfound.CityNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.PersonNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.ProfileNotFoundException;
import com.pragma.route.backend.person.infrastructure.db.repository.CityRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.ProfileRepository;
import com.pragma.route.backend.person.infrastructure.service.PersonApiService;

@SpringBootTest
public class PersonApiServiceImplTests {
	
	private PersonApiService personApiService;
	
	@Mock
	private PersonRepository personRepository;
	
	@Mock
	private CityRepository cityRepository;
	
	@Mock
	private ProfileRepository profileRepository;
	
	@Mock
	private PersonService personService;
	
	@BeforeEach
	public void setup() {
		personApiService = new PersonApiServiceImpl(personRepository, cityRepository, profileRepository, personService);

		Mockito.when(personRepository.getAll()).thenReturn(PersonDataTests.personDtoListOk);
		Mockito.when(personRepository.getById(0)).thenReturn(null);
		Mockito.when(personRepository.getById(1)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personRepository.create(PersonDataTests.personDtoOkToCreate)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personRepository.update(PersonDataTests.personDtoOkCreated)).thenReturn(PersonDataTests.personDtoOkUpdated);

		Mockito.when(cityRepository.exist(0)).thenReturn(false);
		Mockito.when(cityRepository.exist(1)).thenReturn(true);
		
		Mockito.when(profileRepository.exist(0)).thenReturn(false);
		Mockito.when(profileRepository.exist(1)).thenReturn(true);

		Mockito.when(personService.processPersonListToRead(PersonDataTests.personDtoListOk)).thenReturn(PersonDataTests.personDtoListOk);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPersonListToRead(PersonDataTests.personDtoListEmailFormat);
		Mockito.when(personService.processPersonListToWrite(PersonDataTests.personDtoListOk)).thenReturn(PersonDataTests.personDtoListOk);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).processPersonListToWrite(PersonDataTests.personDtoListErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).processPersonListToWrite(PersonDataTests.personDtoListErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPersonListToWrite(PersonDataTests.personDtoListEmailFormat);
		Mockito.when(personService.processPerson(PersonDataTests.personDtoOkToCreate)).thenReturn(PersonDataTests.personDtoOkToCreate);
		Mockito.when(personService.processPerson(PersonDataTests.personDtoOkCreated)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personService.processPerson(PersonDataTests.personDtoOkUpdated)).thenReturn(PersonDataTests.personDtoOkUpdated);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPerson(PersonDataTests.personDtoErrorEmailFormat);
		Mockito.when(personService.prepareToCreate(PersonDataTests.personDtoOkToCreate)).thenReturn(PersonDataTests.personDtoOkToCreate);
		Mockito.when(personService.prepareToCreate(PersonDataTests.personDtoOkDontHaveCity)).thenReturn(PersonDataTests.personDtoOkDontHaveCity);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).prepareToCreate(PersonDataTests.personDtoErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).prepareToCreate(PersonDataTests.personDtoErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).prepareToCreate(PersonDataTests.personDtoErrorEmailFormat);
		Mockito.when(personService.prepareToUpdate(PersonDataTests.personDtoOkCreated)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personService.prepareToUpdate(PersonDataTests.personDtoOkDontHaveCity)).thenReturn(PersonDataTests.personDtoOkDontHaveCity);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).prepareToUpdate(PersonDataTests.personDtoErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).prepareToUpdate(PersonDataTests.personDtoErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).prepareToUpdate(PersonDataTests.personDtoErrorEmailFormat);
	}

	@Test
	public void create() {
		assertThat(personApiService.create(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personDtoOkCreated);
		assertThrows(EmailFormatException.class, () -> personApiService.create(PersonDataTests.personDtoErrorEmailFormat));
		assertThrows(CityNotFoundException.class, () -> personApiService.create(PersonDataTests.personDtoErrorCityNotFound));
		assertThrows(ProfileNotFoundException.class, () -> personApiService.create(PersonDataTests.personDtoErrorProfileNotFound));
	}

	@Test
	public void update() {
		assertThat(personApiService.update(PersonDataTests.personDtoOkCreated)).isEqualTo(PersonDataTests.personDtoOkUpdated);
		assertThrows(EmailFormatException.class, () -> personApiService.update(PersonDataTests.personDtoErrorEmailFormat));
		assertThrows(CityNotFoundException.class, () -> personApiService.update(PersonDataTests.personDtoErrorCityNotFound));
		assertThrows(ProfileNotFoundException.class, () -> personApiService.update(PersonDataTests.personDtoErrorProfileNotFound));
	}

	@Test
	public void getAllPerson() {
		assertThat(personApiService.getAllPerson()).isEqualTo(PersonDataTests.personDtoListOk);
	}

	@Test
	public void getPersonById() {
		assertThat(personApiService.getPersonById(1)).isEqualTo(PersonDataTests.personDtoOkCreated);
		assertThrows(PersonNotFoundException.class, () -> personApiService.getPersonById(0));
	}

}
