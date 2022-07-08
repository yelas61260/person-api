package com.pragma.route.backend.person.application.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.PersonDtoDataTests;
import com.pragma.route.backend.person.application.mapper.PersonWithDtoMapper;

@SpringBootTest
public class PersonWithDtoMapperImplTests {
	
	private PersonWithDtoMapper personWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		personWithDtoMapper = new PersonWithDtoMapperImpl();
	}

	@Test
	public void toDto() {
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personOkToCreate)).isEqualTo(PersonDtoDataTests.personOkToCreate);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personOkDontHaveCity)).isEqualTo(PersonDtoDataTests.personOkDontHaveCity);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorEmailFormat)).isEqualTo(PersonDtoDataTests.personErrorEmailFormat);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorNotEmail)).isEqualTo(PersonDtoDataTests.personErrorNotEmail);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorNotProfile)).isEqualTo(PersonDtoDataTests.personErrorNotProfile);
	}

	@Test
	public void toEntity() {
		assertThat(personWithDtoMapper.toEntity(PersonDtoDataTests.personOkToCreate)).isEqualTo(PersonDataTests.personOkToCreate);
		assertThat(personWithDtoMapper.toEntity(PersonDtoDataTests.personOkDontHaveCity)).isEqualTo(PersonDataTests.personOkDontHaveCity);
		assertThat(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorEmailFormat)).isEqualTo(PersonDataTests.personErrorEmailFormat);
		assertThat(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorNotEmail)).isEqualTo(PersonDataTests.personErrorNotEmail);
		assertThat(personWithDtoMapper.toEntity(PersonDtoDataTests.personErrorNotProfile)).isEqualTo(PersonDataTests.personErrorNotProfile);
	}
	
	@Test
	public void toDtoList() {
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListOk)).isEqualTo(PersonDtoDataTests.personListOk);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListEmailFormat)).isEqualTo(PersonDtoDataTests.personListEmailFormat);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotEmail)).isEqualTo(PersonDtoDataTests.personListErrorNotEmail);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotProfile)).isEqualTo(PersonDtoDataTests.personListErrorNotProfile);
		assertThat(personWithDtoMapper.toDtoList(null)).isEqualTo(new ArrayList<>());
	}

	@Test
	public void toEntityList() {
		assertThat(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListOk)).isEqualTo(PersonDataTests.personListOk);
		assertThat(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListEmailFormat)).isEqualTo(PersonDataTests.personListEmailFormat);
		assertThat(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListErrorNotEmail)).isEqualTo(PersonDataTests.personListErrorNotEmail);
		assertThat(personWithDtoMapper.toEntityList(PersonDtoDataTests.personListErrorNotProfile)).isEqualTo(PersonDataTests.personListErrorNotProfile);
		assertThat(personWithDtoMapper.toEntityList(null)).isEqualTo(new ArrayList<>());
	}

}
