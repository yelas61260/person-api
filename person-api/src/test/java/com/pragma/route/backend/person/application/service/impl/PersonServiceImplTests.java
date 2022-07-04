package com.pragma.route.backend.person.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
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
		
		
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkToCreate)).thenReturn(PersonDataTests.personDtoOkToCreate);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkCreated)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personOkDontHaveCity)).thenReturn(PersonDataTests.personDtoOkDontHaveCity);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorNotProfile)).thenReturn(PersonDataTests.personDtoErrorNotProfile);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorNotEmail)).thenReturn(PersonDataTests.personDtoErrorNotEmail);
		Mockito.when(personWithDtoMapper.toDto(PersonDataTests.personErrorEmailFormat)).thenReturn(PersonDataTests.personDtoErrorEmailFormat);
		
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListOk)).thenReturn(PersonDataTests.personDtoListOk);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListEmailFormat)).thenReturn(PersonDataTests.personDtoListEmailFormat);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotEmail)).thenReturn(PersonDataTests.personDtoListErrorNotEmail);
		Mockito.when(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotProfile)).thenReturn(PersonDataTests.personDtoListErrorNotProfile);

		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoOkToCreate)).thenReturn(PersonDataTests.personOkToCreate);
		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoOkCreated)).thenReturn(PersonDataTests.personOkCreated);
		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoOkDontHaveCity)).thenReturn(PersonDataTests.personOkDontHaveCity);
		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorNotProfile)).thenReturn(PersonDataTests.personErrorNotProfile);
		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorNotEmail)).thenReturn(PersonDataTests.personErrorNotEmail);
		Mockito.when(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorEmailFormat)).thenReturn(PersonDataTests.personErrorEmailFormat);
		
		Mockito.when(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListOk)).thenReturn(PersonDataTests.personListOk);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListEmailFormat)).thenReturn(PersonDataTests.personListEmailFormat);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListErrorNotEmail)).thenReturn(PersonDataTests.personListErrorNotEmail);
		Mockito.when(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListErrorNotProfile)).thenReturn(PersonDataTests.personListErrorNotProfile);
	}
	
	@Test
	public void processPersonListToRead() {
		assertThat(personService.processPersonListToRead(PersonDataTests.personDtoListOk)).isEqualTo(PersonDataTests.personDtoListOk);
		assertThrows(EmailFormatException.class, () -> personService.processPersonListToRead(PersonDataTests.personDtoListEmailFormat));
	}
	
	@Test
	public void processPersonListToWrite() {
		assertThat(personService.processPersonListToWrite(PersonDataTests.personDtoListOk)).isEqualTo(PersonDataTests.personDtoListOk);
		assertThrows(ProfileRequiredException.class, () -> personService.processPersonListToWrite(PersonDataTests.personDtoListErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.processPersonListToWrite(PersonDataTests.personDtoListErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.processPersonListToWrite(PersonDataTests.personDtoListEmailFormat));
	}

	@Test
	public void processPerson() {
		assertThat(personService.processPerson(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personDtoOkToCreate);
		assertThat(personService.processPerson(PersonDataTests.personDtoOkDontHaveCity)).isEqualTo(PersonDataTests.personDtoOkDontHaveCity);
		assertThrows(EmailFormatException.class, () -> personService.processPerson(PersonDataTests.personDtoErrorEmailFormat));
	}

	@Test
	public void prepareToCreate() {
		assertThat(personService.prepareToCreate(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personDtoOkToCreate);
		assertThat(personService.prepareToCreate(PersonDataTests.personDtoOkDontHaveCity)).isEqualTo(PersonDataTests.personDtoOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personService.prepareToCreate(PersonDataTests.personDtoErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.prepareToCreate(PersonDataTests.personDtoErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.prepareToCreate(PersonDataTests.personDtoErrorEmailFormat));
	}

	@Test
	public void prepareToUpdate() {
		assertThat(personService.prepareToUpdate(PersonDataTests.personDtoOkCreated)).isEqualTo(PersonDataTests.personDtoOkCreated);
		assertThat(personService.prepareToUpdate(PersonDataTests.personDtoOkDontHaveCity)).isEqualTo(PersonDataTests.personDtoOkDontHaveCity);
		assertThrows(ProfileRequiredException.class, () -> personService.prepareToUpdate(PersonDataTests.personDtoErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personService.prepareToUpdate(PersonDataTests.personDtoErrorNotEmail));
		assertThrows(EmailFormatException.class, () -> personService.prepareToUpdate(PersonDataTests.personDtoErrorEmailFormat));
	}

}
