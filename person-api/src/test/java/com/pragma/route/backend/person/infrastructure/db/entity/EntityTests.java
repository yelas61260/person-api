package com.pragma.route.backend.person.infrastructure.db.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonEntityDataTests;

@SpringBootTest
public class EntityTests {
	
	@Test
	public void validateCity() {
		CityMySqlEntity cityMySqlEntity1 = new CityMySqlEntity();
		cityMySqlEntity1.setId(PersonEntityDataTests.cityOk.getId());
		cityMySqlEntity1.setName(PersonEntityDataTests.cityOk.getName());
		cityMySqlEntity1.setPersons(PersonEntityDataTests.cityOk.getPersons());

		CityMySqlEntity cityMySqlEntity2 = new CityMySqlEntity();
		cityMySqlEntity2.setName(PersonEntityDataTests.cityOk.getName());

		CityMySqlEntity cityMySqlEntity3 = new CityMySqlEntity();
		cityMySqlEntity3.setId(PersonEntityDataTests.cityOk.getId());
		
		assertTrue(cityMySqlEntity1.equals(PersonEntityDataTests.cityOk));
		assertFalse(cityMySqlEntity2.equals(PersonEntityDataTests.cityOk));
		assertFalse(cityMySqlEntity3.equals(PersonEntityDataTests.cityOk));
		assertTrue(cityMySqlEntity1.toString().equals(PersonEntityDataTests.cityOk.toString()));
		assertTrue(cityMySqlEntity1.hashCode() == PersonEntityDataTests.cityOk.hashCode());
	}
	
	@Test
	public void validateProfile() {
		ProfileMySqlEntity profileMySqlEntity1 = new ProfileMySqlEntity();
		profileMySqlEntity1.setId(PersonEntityDataTests.profileOk.getId());
		profileMySqlEntity1.setName(PersonEntityDataTests.profileOk.getName());
		profileMySqlEntity1.setPersons(PersonEntityDataTests.profileOk.getPersons());

		ProfileMySqlEntity profileMySqlEntity2 = new ProfileMySqlEntity();
		profileMySqlEntity2.setName(PersonEntityDataTests.profileOk.getName());

		ProfileMySqlEntity profileMySqlEntity3 = new ProfileMySqlEntity();
		profileMySqlEntity3.setId(PersonEntityDataTests.profileOk.getId());
		
		assertTrue(profileMySqlEntity1.equals(PersonEntityDataTests.profileOk));
		assertFalse(profileMySqlEntity2.equals(PersonEntityDataTests.profileOk));
		assertFalse(profileMySqlEntity3.equals(PersonEntityDataTests.profileOk));
		assertTrue(profileMySqlEntity1.toString().equals(PersonEntityDataTests.profileOk.toString()));
		assertTrue(profileMySqlEntity1.hashCode() == PersonEntityDataTests.profileOk.hashCode());
	}
	
	@Test
	public void validatePerson() {
		PersonMySqlEntity personMySqlEntity1 = new PersonMySqlEntity();
		personMySqlEntity1.setId(PersonEntityDataTests.personOkCreated.getId());
		personMySqlEntity1.setName(PersonEntityDataTests.personOkCreated.getName());
		personMySqlEntity1.setEmail(PersonEntityDataTests.personOkCreated.getEmail());
		personMySqlEntity1.setCityId(PersonEntityDataTests.personOkCreated.getCityId());
		personMySqlEntity1.setProfileId(PersonEntityDataTests.personOkCreated.getProfileId());
		personMySqlEntity1.setImageId(PersonEntityDataTests.personOkCreated.getImageId());
		personMySqlEntity1.setCreateDate(PersonEntityDataTests.personOkCreated.getCreateDate());
		personMySqlEntity1.setUpdateDate(PersonEntityDataTests.personOkCreated.getUpdateDate());		

		PersonMySqlEntity personMySqlEntity2 = new PersonMySqlEntity();
		personMySqlEntity2.setId(PersonEntityDataTests.personOkCreated.getId());
		
		assertTrue(personMySqlEntity1.equals(PersonEntityDataTests.personOkCreated));
		assertFalse(personMySqlEntity2.equals(PersonEntityDataTests.personOkCreated));
		assertTrue(personMySqlEntity1.toString().equals(PersonEntityDataTests.personOkCreated.toString()));
		assertTrue(personMySqlEntity1.hashCode() == PersonEntityDataTests.personOkCreated.hashCode());
	}

}
