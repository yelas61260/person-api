package com.pragma.route.backend.person.infrastructure.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.ImageDataTests;
import com.pragma.route.backend.person.ImageFileDataTests;
import com.pragma.route.backend.person.PersonDtoDataTests;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.exception.notfound.CityNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.PersonNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.ProfileNotFoundException;
import com.pragma.route.backend.person.infrastructure.client.image.service.ImageApiService;
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
	
	@Mock
	private ImageApiService imageApiService;
	
	@BeforeEach
	public void setup() {
		personApiService = new PersonApiServiceImpl(personRepository, cityRepository, profileRepository, personService, imageApiService);

		Mockito.when(personRepository.getAll()).thenReturn(PersonDtoDataTests.personListOk);
		Mockito.when(personRepository.getById(0)).thenReturn(null);
		Mockito.when(personRepository.getById(1)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personRepository.create(PersonDtoDataTests.personOkToCreate)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personRepository.update(PersonDtoDataTests.personOkCreated)).thenReturn(PersonDtoDataTests.personOkUpdated);

		Mockito.when(cityRepository.exist(0)).thenReturn(false);
		Mockito.when(cityRepository.exist(1)).thenReturn(true);
		
		Mockito.when(profileRepository.exist(0)).thenReturn(false);
		Mockito.when(profileRepository.exist(1)).thenReturn(true);
		

		Mockito.when(personService.processPersonListToRead(PersonDtoDataTests.personListOk)).thenReturn(PersonDtoDataTests.personListOk);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPersonListToRead(PersonDtoDataTests.personListEmailFormat);
		Mockito.when(personService.processPersonListToWrite(PersonDtoDataTests.personListOk)).thenReturn(PersonDtoDataTests.personListOk);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).processPersonListToWrite(PersonDtoDataTests.personListErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).processPersonListToWrite(PersonDtoDataTests.personListErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPersonListToWrite(PersonDtoDataTests.personListEmailFormat);
		
		Mockito.when(personService.processPerson(PersonDtoDataTests.personOkToCreate)).thenReturn(PersonDtoDataTests.personOkToCreate);
		Mockito.when(personService.processPerson(PersonDtoDataTests.personOkCreated)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personService.processPerson(PersonDtoDataTests.personOkUpdated)).thenReturn(PersonDtoDataTests.personOkUpdated);
		Mockito.doThrow(EmailFormatException.class).when(personService).processPerson(PersonDtoDataTests.personErrorEmailFormat);
		
		Mockito.when(personService.prepareToCreate(PersonDtoDataTests.personOkToCreate)).thenReturn(PersonDtoDataTests.personOkToCreate);
		Mockito.when(personService.prepareToCreate(PersonDtoDataTests.personOkDontHaveCity)).thenReturn(PersonDtoDataTests.personOkDontHaveCity);
		Mockito.when(personService.prepareToCreate(PersonDtoDataTests.personErrorCityNotFound)).thenReturn(PersonDtoDataTests.personErrorCityNotFound);
		Mockito.when(personService.prepareToCreate(PersonDtoDataTests.personErrorProfileNotFound)).thenReturn(PersonDtoDataTests.personErrorProfileNotFound);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).prepareToCreate(PersonDtoDataTests.personErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).prepareToCreate(PersonDtoDataTests.personErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).prepareToCreate(PersonDtoDataTests.personErrorEmailFormat);
		
		Mockito.when(personService.prepareToUpdate(PersonDtoDataTests.personOkCreated)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personService.prepareToUpdate(PersonDtoDataTests.personOkDontHaveCity)).thenReturn(PersonDtoDataTests.personOkDontHaveCity);
		Mockito.when(personService.prepareToUpdate(PersonDtoDataTests.personErrorCityNotFound)).thenReturn(PersonDtoDataTests.personErrorCityNotFound);
		Mockito.when(personService.prepareToUpdate(PersonDtoDataTests.personErrorProfileNotFound)).thenReturn(PersonDtoDataTests.personErrorProfileNotFound);
		Mockito.doThrow(ProfileRequiredException.class).when(personService).prepareToUpdate(PersonDtoDataTests.personErrorNotProfile);
		Mockito.doThrow(EmailRequiredException.class).when(personService).prepareToUpdate(PersonDtoDataTests.personErrorNotEmail);
		Mockito.doThrow(EmailFormatException.class).when(personService).prepareToUpdate(PersonDtoDataTests.personErrorEmailFormat);
		
		Mockito.when(imageApiService.create(ImageFileDataTests.multipartFileOk)).thenReturn(ImageDataTests.imageOKCreated);
		Mockito.when(imageApiService.update(ImageDataTests.imageOKCreated.getImageId(), ImageFileDataTests.multipartFileOk)).thenReturn(ImageDataTests.imageOKCreated);
		Mockito.when(imageApiService.getImageBase64(ImageDataTests.imageOKCreated.getImageId())).thenReturn(ImageDataTests.imageOKCreated.getImageBase64());
	}

	@Test
	public void create() {
		assertThat(personApiService.create(PersonDtoDataTests.personOkToCreate, null)).isEqualTo(PersonDtoDataTests.personOkCreated);
		assertThat(personApiService.create(PersonDtoDataTests.personOkToCreate, ImageFileDataTests.multipartFileOk)).isEqualTo(PersonDtoDataTests.personOkCreated);
		assertThrows(EmailFormatException.class, () -> personApiService.create(PersonDtoDataTests.personErrorEmailFormat, null));
		assertThrows(CityNotFoundException.class, () -> personApiService.create(PersonDtoDataTests.personErrorCityNotFound, null));
		assertThrows(ProfileNotFoundException.class, () -> personApiService.create(PersonDtoDataTests.personErrorProfileNotFound, null));
	}

	@Test
	public void update() {
		assertThat(personApiService.update(PersonDtoDataTests.personOkCreated, null)).isEqualTo(PersonDtoDataTests.personOkUpdated);
		assertThat(personApiService.update(PersonDtoDataTests.personOkCreated, ImageFileDataTests.multipartFileOk)).isEqualTo(PersonDtoDataTests.personOkUpdated);
		assertThrows(EmailFormatException.class, () -> personApiService.update(PersonDtoDataTests.personErrorEmailFormat, null));
		assertThrows(CityNotFoundException.class, () -> personApiService.update(PersonDtoDataTests.personErrorCityNotFound, null));
		assertThrows(ProfileNotFoundException.class, () -> personApiService.update(PersonDtoDataTests.personErrorProfileNotFound, null));
	}

	@Test
	public void getAllPerson() {
		assertThat(personApiService.getAllPerson()).isEqualTo(PersonDtoDataTests.personListOk);
	}

	@Test
	public void getPersonById() {
		assertThat(personApiService.getPersonById(1)).isEqualTo(PersonDtoDataTests.personOkCreated);
		assertThrows(PersonNotFoundException.class, () -> personApiService.getPersonById(0));
	}

}
