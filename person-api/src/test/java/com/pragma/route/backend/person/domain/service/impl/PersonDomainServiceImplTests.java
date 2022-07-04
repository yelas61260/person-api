package com.pragma.route.backend.person.domain.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.service.PersonDomainService;
import com.pragma.route.backend.person.domain.service.validator.PersonValidatorDomainService;

@SpringBootTest
public class PersonDomainServiceImplTests {
	
	private PersonDomainService personDomainService;
	
	@Mock
	private PersonValidatorDomainService personValidatorDomainService;
	
	@BeforeEach
	public void setup() {
		personDomainService = new PersonDomainServiceImpl(personValidatorDomainService);
		
		Mockito.doNothing().when(personValidatorDomainService).validateEntityRequired(PersonDataTests.personOkToCreate);
		Mockito.doNothing().when(personValidatorDomainService).validateEntityRequired(PersonDataTests.personOkDontHaveCity);
		Mockito.doThrow(ProfileRequiredException.class).when(personValidatorDomainService).validateEntityRequired(PersonDataTests.personErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personValidatorDomainService).validateEntityRequired(PersonDataTests.personErrorNotEmail);
		
		Mockito.doNothing().when(personValidatorDomainService).validateEntityFormat(PersonDataTests.personOkToCreate);
		Mockito.doNothing().when(personValidatorDomainService).validateEntityFormat(PersonDataTests.personOkDontHaveCity);
		Mockito.doThrow(EmailFormatException.class).when(personValidatorDomainService).validateEntityFormat(PersonDataTests.personErrorEmailFormat);
	}
	
	@Test
	public void processPersonListToRead() {
		assertThat(personDomainService.processPersonListToRead(PersonDataTests.personListOk)).isEqualTo(PersonDataTests.personListOk);
		assertThrows(EmailFormatException.class, () -> personDomainService.processPersonListToRead(PersonDataTests.personListEmailFormat));
	}
	
	@Test
	public void processPersonListToWrite() {
		assertThat(personDomainService.processPersonListToWrite(PersonDataTests.personListOk)).isEqualTo(PersonDataTests.personListOk);
		assertThrows(ProfileRequiredException.class, () -> personDomainService.processPersonListToWrite(PersonDataTests.personListErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personDomainService.processPersonListToWrite(PersonDataTests.personListErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personDomainService.processPersonListToWrite(PersonDataTests.personListEmailFormat));
	}

	@Test
	public void processPerson() {
		assertThat(personDomainService.processPerson(PersonDataTests.personOkToCreate)).isEqualTo(PersonDataTests.personOkToCreate);
		assertThat(personDomainService.processPerson(PersonDataTests.personOkDontHaveCity)).isEqualTo(PersonDataTests.personOkDontHaveCity);
		assertThrows(EmailFormatException.class, () -> personDomainService.processPerson(PersonDataTests.personErrorEmailFormat));
	}

	@Test
	public void prepareToCreate() {
		assertThat(personDomainService.prepareToCreate(PersonDataTests.personOkToCreate)).isEqualTo(PersonDataTests.personOkToCreate);
		assertThat(personDomainService.prepareToCreate(PersonDataTests.personOkDontHaveCity)).isEqualTo(PersonDataTests.personOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personDomainService.prepareToCreate(PersonDataTests.personErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personDomainService.prepareToCreate(PersonDataTests.personErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personDomainService.prepareToCreate(PersonDataTests.personErrorEmailFormat));
	}

	@Test
	public void prepareToUpdate() {
		assertThat(personDomainService.prepareToUpdate(PersonDataTests.personOkToCreate)).isEqualTo(PersonDataTests.personOkToCreate);
		assertThat(personDomainService.prepareToUpdate(PersonDataTests.personOkDontHaveCity)).isEqualTo(PersonDataTests.personOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personDomainService.prepareToUpdate(PersonDataTests.personErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personDomainService.prepareToUpdate(PersonDataTests.personErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personDomainService.prepareToUpdate(PersonDataTests.personErrorEmailFormat));
	}

}
