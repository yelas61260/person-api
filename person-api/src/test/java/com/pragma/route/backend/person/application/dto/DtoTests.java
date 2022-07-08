package com.pragma.route.backend.person.application.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDtoDataTests;

@SpringBootTest
public class DtoTests {

	@Test
	public void validatePersonDto() {
		PersonDto personDto = new PersonDto();
		personDto.setId(PersonDtoDataTests.personOkCreated.getId());
		personDto.setName(PersonDtoDataTests.personOkCreated.getName());
		personDto.setEmail(PersonDtoDataTests.personOkCreated.getEmail());
		personDto.setCityId(PersonDtoDataTests.personOkCreated.getCityId());
		personDto.setCityName(PersonDtoDataTests.personOkCreated.getCityName());
		personDto.setProfileId(PersonDtoDataTests.personOkCreated.getProfileId());
		personDto.setProfileName(PersonDtoDataTests.personOkCreated.getProfileName());
		personDto.setImageId(PersonDtoDataTests.personOkCreated.getImageId());
		personDto.setCreateDate(PersonDtoDataTests.personOkCreated.getCreateDate());
		personDto.setUpdateDate(PersonDtoDataTests.personOkCreated.getUpdateDate());
		
		assertTrue(personDto.equals(PersonDtoDataTests.personOkCreated));
		assertTrue(personDto.toString().equals(PersonDtoDataTests.personOkCreated.toString()));
		assertTrue(personDto.hashCode() == PersonDtoDataTests.personOkCreated.hashCode());
	}
	
}
