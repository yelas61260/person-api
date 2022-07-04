package com.pragma.route.backend.person.domain.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;

@SpringBootTest
public class ModelTests {
	
	@Test
	public void validatePerson() {
		Person person = new Person();
		person.setId(PersonDataTests.personOkCreated.getId());
		person.setName(PersonDataTests.personOkCreated.getName());
		person.setEmail(PersonDataTests.personOkCreated.getEmail());
		person.setCityId(PersonDataTests.personOkCreated.getCityId());
		person.setCityName(PersonDataTests.personOkCreated.getCityName());
		person.setProfileId(PersonDataTests.personOkCreated.getProfileId());
		person.setProfileName(PersonDataTests.personOkCreated.getProfileName());
		person.setImageId(PersonDataTests.personOkCreated.getImageId());
		person.setCreateDate(PersonDataTests.personOkCreated.getCreateDate());
		person.setUpdateDate(PersonDataTests.personOkCreated.getUpdateDate());
		
		assertTrue(person.equals(PersonDataTests.personOkCreated));
		assertTrue(person.toString().equals(PersonDataTests.personOkCreated.toString()));
		assertTrue(person.hashCode() == PersonDataTests.personOkCreated.hashCode());
	}

}
