package com.pragma.route.backend.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;
import com.pragma.route.backend.person.domain.model.Person;
import com.pragma.route.backend.person.infrastructure.db.entity.CityMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.ProfileMySqlEntity;

@SpringBootTest
public class PersonDataTests {
	
	
	//Objetos de dominio
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
	
	//Objetos Dto	
	public static final PersonDTO personDtoOkToCreate = PersonDTO.builder()
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
	
	public static final PersonDTO personDtoOkCreated = PersonDTO.builder()
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
	
	public static final PersonDTO personDtoOkUpdated = PersonDTO.builder()
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

	public static final PersonDTO personDtoOkDontHaveCity = PersonDTO.builder()
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

	public static final PersonDTO personDtoOkDontHaveProfile = PersonDTO.builder()
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
	
	public static final List<PersonDTO> personDtoListOk = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personDtoOkCreated);
			add(personDtoOkDontHaveCity);
		}
	};
	
	public static final PersonDTO personDtoErrorNotProfile = PersonDTO.builder()
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
	
	public static final List<PersonDTO> personDtoListErrorNotProfile = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personDtoOkCreated);
			add(personDtoErrorNotProfile);
		}
	};

	public static final PersonDTO personDtoErrorNotEmail = PersonDTO.builder()
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
	
	public static final List<PersonDTO> personDtoListErrorNotEmail = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personDtoOkCreated);
			add(personDtoErrorNotEmail);
		}
	};
	
	public static final PersonDTO personDtoErrorEmailFormat = PersonDTO.builder()
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
	
	public static final List<PersonDTO> personDtoListEmailFormat = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personDtoOkCreated);
			add(personDtoErrorEmailFormat);
		}
	};
	
	public static final PersonDTO personDtoErrorCityNotFound = PersonDTO.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(2)
			.cityName("Cali")
			.profileId(1)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final PersonDTO personDtoErrorProfileNotFound = PersonDTO.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(1)
			.cityName("Cali")
			.profileId(2)
			.profileName("Desarrollador de software")
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	//Objetos Entity
	public static final CityMySqlEntity cityEntityEmpty = CityMySqlEntity.builder().build();
	public static final CityMySqlEntity cityEntityOk = CityMySqlEntity.builder()
			.id(1)
			.name("Cali")
			.build();
	
	public static final ProfileMySqlEntity profileEntityEmpty = ProfileMySqlEntity.builder().build();
	public static final ProfileMySqlEntity profileEntityOk = ProfileMySqlEntity.builder()
			.id(1)
			.name("Desarrollador de software")
			.build();
	
	public static final PersonMySqlEntity personEntityOkToCreate = PersonMySqlEntity.builder()
			.id(0)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityEntityOk)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final PersonMySqlEntity personEntityOkCreated = PersonMySqlEntity.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityEntityOk)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.createDate)
			.build();
	
	public static final PersonMySqlEntity personEntityOkUpdated = PersonMySqlEntity.builder()
			.id(1)
			.name("Cristian")
			.email("cristian33@prueba.com")
			.cityId(cityEntityOk)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final PersonMySqlEntity personEntityOkDontHaveCity = PersonMySqlEntity.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

	public static final PersonMySqlEntity personEntityOkDontHaveProfile = PersonMySqlEntity.builder()
			.id(10)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(cityEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personEntityListOk = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personEntityOkCreated);
			add(personEntityOkDontHaveCity);
		}
	};
	
	public static final PersonMySqlEntity personEntityErrorNotProfile = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba33@prueba.com")
			.cityId(cityEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personEntityListErrorNotProfile = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personEntityOkCreated);
			add(personEntityErrorNotProfile);
		}
	};

	public static final PersonMySqlEntity personEntityErrorNotEmail = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.cityId(cityEntityOk)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personEntityListErrorNotEmail = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personEntityOkCreated);
			add(personEntityErrorNotEmail);
		}
	};
	
	public static final PersonMySqlEntity personEntityErrorEmailFormat = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(cityEntityOk)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final List<PersonMySqlEntity> personEntityListEmailFormat = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personEntityOkCreated);
			add(personEntityErrorEmailFormat);
		}
	};
	
	public static final PersonMySqlEntity personEntityErrorCityNotFound = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(null)
			.profileId(profileEntityOk)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();
	
	public static final PersonMySqlEntity personEntityErrorProfileNotFound = PersonMySqlEntity.builder()
			.id(0)
			.name("Prueba")
			.email("prueba@33@prueba.com")
			.cityId(cityEntityOk)
			.profileId(null)
			.imageId("PI-1")
			.createDate(DateDataTests.createDate)
			.updateDate(DateDataTests.updateDate)
			.build();

}
