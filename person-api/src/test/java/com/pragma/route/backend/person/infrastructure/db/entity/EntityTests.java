package com.pragma.route.backend.person.infrastructure.db.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;

@SpringBootTest
public class EntityTests {
	
	@Test
	public void validateCity() {
		CityMySqlEntity cityMySqlEntity1 = new CityMySqlEntity();
		cityMySqlEntity1.setId(PersonDataTests.cityEntityOk.getId());
		cityMySqlEntity1.setName(PersonDataTests.cityEntityOk.getName());
		cityMySqlEntity1.setPersons(PersonDataTests.cityEntityOk.getPersons());

		CityMySqlEntity cityMySqlEntity2 = new CityMySqlEntity();
		cityMySqlEntity2.setName(PersonDataTests.cityEntityOk.getName());

		CityMySqlEntity cityMySqlEntity3 = new CityMySqlEntity();
		cityMySqlEntity3.setId(PersonDataTests.cityEntityOk.getId());
		
		assertTrue(cityMySqlEntity1.equals(PersonDataTests.cityEntityOk));
		assertFalse(cityMySqlEntity2.equals(PersonDataTests.cityEntityOk));
		assertFalse(cityMySqlEntity3.equals(PersonDataTests.cityEntityOk));
		assertTrue(cityMySqlEntity1.toString().equals(PersonDataTests.cityEntityOk.toString()));
		assertTrue(cityMySqlEntity1.hashCode() == PersonDataTests.cityEntityOk.hashCode());
	}
	
	@Test
	public void validateProfile() {
		ProfileMySqlEntity profileMySqlEntity1 = new ProfileMySqlEntity();
		profileMySqlEntity1.setId(PersonDataTests.profileEntityOk.getId());
		profileMySqlEntity1.setName(PersonDataTests.profileEntityOk.getName());
		profileMySqlEntity1.setPersons(PersonDataTests.profileEntityOk.getPersons());

		ProfileMySqlEntity profileMySqlEntity2 = new ProfileMySqlEntity();
		profileMySqlEntity2.setName(PersonDataTests.profileEntityOk.getName());

		ProfileMySqlEntity profileMySqlEntity3 = new ProfileMySqlEntity();
		profileMySqlEntity3.setId(PersonDataTests.profileEntityOk.getId());
		
		assertTrue(profileMySqlEntity1.equals(PersonDataTests.profileEntityOk));
		assertFalse(profileMySqlEntity2.equals(PersonDataTests.profileEntityOk));
		assertFalse(profileMySqlEntity3.equals(PersonDataTests.profileEntityOk));
		assertTrue(profileMySqlEntity1.toString().equals(PersonDataTests.profileEntityOk.toString()));
		assertTrue(profileMySqlEntity1.hashCode() == PersonDataTests.profileEntityOk.hashCode());
	}
	
	@Test
	public void validatePerson() {
		PersonMySqlEntity personMySqlEntity1 = new PersonMySqlEntity();
		personMySqlEntity1.setId(PersonDataTests.personEntityOkCreated.getId());
		personMySqlEntity1.setName(PersonDataTests.personEntityOkCreated.getName());
		personMySqlEntity1.setEmail(PersonDataTests.personEntityOkCreated.getEmail());
		personMySqlEntity1.setCityId(PersonDataTests.personEntityOkCreated.getCityId());
		personMySqlEntity1.setProfileId(PersonDataTests.personEntityOkCreated.getProfileId());
		personMySqlEntity1.setImageId(PersonDataTests.personEntityOkCreated.getImageId());
		personMySqlEntity1.setCreateDate(PersonDataTests.personEntityOkCreated.getCreateDate());
		personMySqlEntity1.setUpdateDate(PersonDataTests.personEntityOkCreated.getUpdateDate());		

		PersonMySqlEntity personMySqlEntity2 = new PersonMySqlEntity();
		personMySqlEntity2.setId(PersonDataTests.personEntityOkCreated.getId());
		
		assertTrue(personMySqlEntity1.equals(PersonDataTests.personEntityOkCreated));
		assertFalse(personMySqlEntity2.equals(PersonDataTests.personEntityOkCreated));
		assertTrue(personMySqlEntity1.toString().equals(PersonDataTests.personEntityOkCreated.toString()));
		assertTrue(personMySqlEntity1.hashCode() == PersonDataTests.personEntityOkCreated.hashCode());
	}

}
