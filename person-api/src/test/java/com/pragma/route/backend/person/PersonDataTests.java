package com.pragma.route.backend.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;
import com.pragma.route.backend.person.domain.model.Person;

@SpringBootTest
public class PersonDataTests {
	
	public static final Person personOkToCreate = Person.builder()
			.id(0)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final Person personOkCreated = Person.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final Person personOkUpdated = Person.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final Person personOkDontHaveCity = Person.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(ApiGlobalConstant.CITY_NULL_ID)
			.cityName(ApiGlobalConstant.CITY_NULL_TEXT)
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final Person personOkDontHaveProfile = Person.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(ApiGlobalConstant.PROFILE_NULL_ID)
			.profileName(ApiGlobalConstant.PROFILE_NULL_TEXT)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<Person> personListOk = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personOkDontHaveCity);
		}
	};
	
	public static final Person personErrorNotProfile = Person.builder()
			.id(0)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(ApiGlobalConstant.PROFILE_NULL_ID)
			.profileName(ApiGlobalConstant.PROFILE_NULL_TEXT)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<Person> personListErrorNotProfile = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotProfile);
		}
	};

	public static final Person personErrorNotEmail = Person.builder()
			.id(0)
			.name("Prueba")
			.cityId(1)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final Person personErrorEmailEmpty = Person.builder()
			.id(0)
			.name("Prueba")
			.cityId(1)
			.cityName("Cali")
			.email("")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<Person> personListErrorNotEmail = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotEmail);
		}
	};
	
	public static final Person personErrorEmailFormat = Person.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<Person> personListEmailFormat = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorEmailFormat);
		}
	};
	
	public static final Person personErrorCityNotFound = Person.builder()
			.id(0)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(2)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final Person personErrorProfileNotFound = Person.builder()
			.id(0)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(2)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

}
