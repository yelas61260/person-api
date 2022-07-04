package com.pragma.route.backend.person.application.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;

@SpringBootTest
public class DtoTests {

	@Test
	public void validatePersonDto() {
		PersonDTO personDto = new PersonDTO();
		personDto.setId(PersonDataTests.personDtoOkCreated.getId());
		personDto.setName(PersonDataTests.personDtoOkCreated.getName());
		personDto.setEmail(PersonDataTests.personDtoOkCreated.getEmail());
		personDto.setCityId(PersonDataTests.personDtoOkCreated.getCityId());
		personDto.setCityName(PersonDataTests.personDtoOkCreated.getCityName());
		personDto.setProfileId(PersonDataTests.personDtoOkCreated.getProfileId());
		personDto.setProfileName(PersonDataTests.personDtoOkCreated.getProfileName());
		personDto.setImageId(PersonDataTests.personDtoOkCreated.getImageId());
		personDto.setCreateDate(PersonDataTests.personDtoOkCreated.getCreateDate());
		personDto.setUpdateDate(PersonDataTests.personDtoOkCreated.getUpdateDate());
		
		assertTrue(personDto.equals(PersonDataTests.personDtoOkCreated));
		assertTrue(personDto.toString().equals(PersonDataTests.personDtoOkCreated.toString()));
		assertTrue(personDto.hashCode() == PersonDataTests.personDtoOkCreated.hashCode());
	}
	
}
