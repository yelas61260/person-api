package com.pragma.route.backend.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.application.dto.PersonDto;
import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;

@SpringBootTest
public class PersonDtoDataTests {
	
	public static final PersonDto personOkToCreate = PersonDto.builder()
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
	
	public static final PersonDto personOkCreated = PersonDto.builder()
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
	
	public static final PersonDto personOkUpdated = PersonDto.builder()
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

	public static final PersonDto personOkDontHaveCity = PersonDto.builder()
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

	public static final PersonDto personOkDontHaveProfile = PersonDto.builder()
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
	
	public static final List<PersonDto> personListOk = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personOkDontHaveCity);
		}
	};
	
	public static final PersonDto personErrorNotProfile = PersonDto.builder()
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
	
	public static final List<PersonDto> personListErrorNotProfile = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotProfile);
		}
	};

	public static final PersonDto personErrorNotEmail = PersonDto.builder()
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
	
	public static final List<PersonDto> personListErrorNotEmail = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorNotEmail);
		}
	};
	
	public static final PersonDto personErrorEmailFormat = PersonDto.builder()
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
	
	public static final List<PersonDto> personListEmailFormat = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

		{
			add(personOkCreated);
			add(personErrorEmailFormat);
		}
	};
	
	public static final PersonDto personErrorCityNotFound = PersonDto.builder()
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
	
	public static final PersonDto personErrorProfileNotFound = PersonDto.builder()
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

}
