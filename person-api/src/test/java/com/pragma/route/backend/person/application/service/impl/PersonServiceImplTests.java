package com.pragma.route.backend.person.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.PersonDtoDataTests;
import com.pragma.route.backend.person.application.mapper.PersonWithDtoMapper;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.service.PersonDomainService;

@SpringBootTest
public class PersonServiceImplTests {
	
	private PersonService personService;
	
	@Mock
	private PersonDomainService personDomainService;
	
	@Mock
	private PersonWithDtoMapper personWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		personService = new PersonServiceImpl(personDomainService, personWithDtoMapper);		

		Mockito.when(personDomainService.processPersonListToRead(PersonDataTests.personListOk)).thenReturn(PersonDataTests.personListOk);
		Mockito.doThrow(EmailFormatException.class).when(personDomainService).processPersonListToRead(PersonDataTests.personListEmailFormat);
		
		Mockito.when(personDomainService.processPersonListToWrite(PersonDataTests.personListOk)).thenReturn(PersonDataTests.personListOk);
		Mockito.doThrow(ProfileRequiredException.class).when(personDomainService).processPersonListToWrite(PersonDataTests.personListErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personDomainService).processPersonListToWrite(PersonDataTests.personListErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personDomainService).processPersonListToWrite(PersonDataTests.personListEmailFormat);

		Mockito.when(personDomainService.processPerson(PersonDataTests.personOkToCreate)).thenReturn(PersonDataTests.personOkToCreate);
		Mockito.when(personDomainService.processPerson(PersonDataTests.personOkDontHaveCity)).thenReturn(PersonDataTests.personOkDontHaveCity);
		Mockito.doThrow(EmailFormatException.class).when(personDomainService).processPerson(PersonDataTests.personErrorEmailFormat);
		
		Mockito.when(personDomainService.prepareToCreate(PersonDataTests.personOkToCreate)).thenReturn(PersonDataTests.personOkToCreate);
		Mockito.when(personDomainService.prepareToCreate(PersonDataTests.personOkDontHaveCity)).thenReturn(PersonDataTests.personOkDontHaveCity);
		Mockito.doThrow(ProfileRequiredException.class).when(personDomainService).prepareToCreate(PersonDataTests.personErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personDomainService).prepareToCreate(PersonDataTests.personErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personDomainService).prepareToCreate(PersonDataTests.personErrorEmailFormat);

		Mockito.when(personDomainService.prepareToUpdate(PersonDataTests.personOkCreated)).thenReturn(PersonDataTests.personOkCreated);
		Mockito.when(personDomainService.prepareToUpdate(PersonDataTests.personOkDontHaveCity)).thenReturn(PersonDataTests.personOkDontHaveCity);
		Mockito.doThrow(ProfileRequiredException.class).when(personDomainService).prepareToUpdate(PersonDataTests.personErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personDomainService).prepareToUpdate(PersonDataTests.personErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personDomainService).prepareToUpdate(PersonDataTests.personErrorEmailFormat);
		
		
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkToCreate)).thenReturn(PersonDtoDataTests.personOkToCreate);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkCreated)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkDontHaveCity)).thenReturn(PersonDtoDataTests.personOkDontHaveCity);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorNotProfile)).thenReturn(PersonDtoDataTests.personErrorNotProfile);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorNotEmail)).thenReturn(PersonDtoDataTests.personErrorNotEmail);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorEmailFormat)).thenReturn(PersonDtoDataTests.personErrorEmailFormat);
		
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListOk)).thenReturn(PersonDtoDataTests.personListOk);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListEmailFormat)).thenReturn(PersonDtoDataTests.personListEmailFormat);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotEmail)).thenReturn(PersonDtoDataTests.personListErrorNotEmail);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotProfile)).thenReturn(PersonDtoDataTests.personListErrorNotProfile);

		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personOkToCreate)).thenReturn(PersonDataTests.personOkToCreate);
		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personOkCreated)).thenReturn(PersonDataTests.personOkCreated);
		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personOkDontHaveCity)).thenReturn(PersonDataTests.personOkDontHaveCity);
		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorNotProfile)).thenReturn(PersonDataTests.personErrorNotProfile);
		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorNotEmail)).thenReturn(PersonDataTests.personErrorNotEmail);
		Mockito.when(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorEmailFormat)).thenReturn(PersonDataTests.personErrorEmailFormat);
		
		Mockito.when(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListOk)).thenReturn(PersonDataTests.personListOk);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListEmailFormat)).thenReturn(PersonDataTests.personListEmailFormat);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListErrorNotEmail)).thenReturn(PersonDataTests.personListErrorNotEmail);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListErrorNotProfile)).thenReturn(PersonDataTests.personListErrorNotProfile);
	}
	
	@Test
	public void processPersonListToRead() {
		assertThat(personService.processPersonListToRead(PersonDtoDataTests.personListOk)).isEqualTo(PersonDtoDataTests.personListOk);
		assertThrows(EmailFormatException.class, () -> personService.processPersonListToRead(PersonDtoDataTests.personListEmailFormat));
	}
	
	@Test
	public void processPersonListToWrite() {
		assertThat(personService.processPersonListToWrite(PersonDtoDataTests.personListOk)).isEqualTo(PersonDtoDataTests.personListOk);
		assertThrows(ProfileRequiredException.class, () -> personService.processPersonListToWrite(PersonDtoDataTests.personListErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.processPersonListToWrite(PersonDtoDataTests.personListErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.processPersonListToWrite(PersonDtoDataTests.personListEmailFormat));
	}

	@Test
	public void processPerson() {
		assertThat(personService.processPerson(PersonDtoDataTests.personOkToCreate)).isEqualTo(PersonDtoDataTests.personOkToCreate);
		assertThat(personService.processPerson(PersonDtoDataTests.personOkDontHaveCity)).isEqualTo(PersonDtoDataTests.personOkDontHaveCity);
		assertThrows(EmailFormatException.class, () -> personService.processPerson(PersonDtoDataTests.personErrorEmailFormat));
	}

	@Test
	public void prepareToCreate() {
		assertThat(personService.prepareToCreate(PersonDtoDataTests.personOkToCreate)).isEqualTo(PersonDtoDataTests.personOkToCreate);
		assertThat(personService.prepareToCreate(PersonDtoDataTests.personOkDontHaveCity)).isEqualTo(PersonDtoDataTests.personOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personService.prepareToCreate(PersonDtoDataTests.personErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.prepareToCreate(PersonDtoDataTests.personErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.prepareToCreate(PersonDtoDataTests.personErrorEmailFormat));
	}

	@Test
	public void prepareToUpdate() {
		assertThat(personService.prepareToUpdate(PersonDtoDataTests.personOkCreated)).isEqualTo(PersonDtoDataTests.personOkCreated);
		assertThat(personService.prepareToUpdate(PersonDtoDataTests.personOkDontHaveCity)).isEqualTo(PersonDtoDataTests.personOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personService.prepareToUpdate(PersonDtoDataTests.personErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.prepareToUpdate(PersonDtoDataTests.personErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.prepareToUpdate(PersonDtoDataTests.personErrorEmailFormat));
	}

}
