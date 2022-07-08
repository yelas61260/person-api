package com.pragma.route.backend.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.infrastructure.db.entity.CityMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.ProfileMySqlEntity;

@SpringBootTest
public class PersonEntityDataTests {

	public static final CityMySqlEntity cityEmpty = CityMySqlEntity.builder().build();
	public static final CityMySqlEntity cityOk = CityMySqlEntity.builder()
			.id(1)
			.name("Cali")
			.build();
	
	public static final ProfileMySqlEntity profileEmpty = ProfileMySqlEntity.builder().build();
	public static final ProfileMySqlEntity profileOk = ProfileMySqlEntity.builder()
			.id(1)
			.name("Desarrollador de software")
			.build();
	
	public static final PersonMySqlEntity personOkToCreate = PersonMySqlEntity.builder()
			.id(0)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityOk)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final PersonMySqlEntity personOkCreated = PersonMySqlEntity.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityOk)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final PersonMySqlEntity personOkUpdated = PersonMySqlEntity.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityOk)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final PersonMySqlEntity personOkDontHaveCity = PersonMySqlEntity.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final PersonMySqlEntity personOkDontHaveProfile = PersonMySqlEntity.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(cityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personListOk = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personOkDontHaveCity);
		}
	};
	
	public static final PersonMySqlEntity personErrorNotProfile = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(cityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personListErrorNotProfile = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotProfile);
		}
	};

	public static final PersonMySqlEntity personErrorNotEmail = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.cityId(cityOk)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personListErrorNotEmail = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotEmail);
		}
	};
	
	public static final PersonMySqlEntity personErrorEmailFormat = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(cityOk)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personListEmailFormat = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorEmailFormat);
		}
	};
	
	public static final PersonMySqlEntity personErrorCityNotFound = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(null)
			.profileId(profileOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final PersonMySqlEntity personErrorProfileNotFound = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(cityOk)
			.profileId(null)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
}
