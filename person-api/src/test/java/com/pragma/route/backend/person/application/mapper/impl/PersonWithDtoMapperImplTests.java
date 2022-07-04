package com.pragma.route.backend.person.application.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
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
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personOkToCreate)).isEqualTo(PersonDataTests.personDtoOkToCreate);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personOkDontHaveCity)).isEqualTo(PersonDataTests.personDtoOkDontHaveCity);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorEmailFormat)).isEqualTo(PersonDataTests.personDtoErrorEmailFormat);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorNotEmail)).isEqualTo(PersonDataTests.personDtoErrorNotEmail);
		assertThat(personWithDtoMapper.toDto(PersonDataTests.personErrorNotProfile)).isEqualTo(PersonDataTests.personDtoErrorNotProfile);
	}

	@Test
	public void toEntity() {
		assertThat(personWithDtoMapper.toEntity(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personOkToCreate);
		assertThat(personWithDtoMapper.toEntity(PersonDataTests.personDtoOkDontHaveCity)).isEqualTo(PersonDataTests.personOkDontHaveCity);
		assertThat(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorEmailFormat)).isEqualTo(PersonDataTests.personErrorEmailFormat);
		assertThat(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorNotEmail)).isEqualTo(PersonDataTests.personErrorNotEmail);
		assertThat(personWithDtoMapper.toEntity(PersonDataTests.personDtoErrorNotProfile)).isEqualTo(PersonDataTests.personErrorNotProfile);
	}
	
	@Test
	public void toDtoList() {
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListOk)).isEqualTo(PersonDataTests.personDtoListOk);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListEmailFormat)).isEqualTo(PersonDataTests.personDtoListEmailFormat);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotEmail)).isEqualTo(PersonDataTests.personDtoListErrorNotEmail);
		assertThat(personWithDtoMapper.toDtoList(PersonDataTests.personListErrorNotProfile)).isEqualTo(PersonDataTests.personDtoListErrorNotProfile);
		assertThat(personWithDtoMapper.toDtoList(null)).isEqualTo(new ArrayList<>());
	}

	@Test
	public void toEntityList() {
		assertThat(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListOk)).isEqualTo(PersonDataTests.personListOk);
		assertThat(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListEmailFormat)).isEqualTo(PersonDataTests.personListEmailFormat);
		assertThat(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListErrorNotEmail)).isEqualTo(PersonDataTests.personListErrorNotEmail);
		assertThat(personWithDtoMapper.toEntityList(PersonDataTests.personDtoListErrorNotProfile)).isEqualTo(PersonDataTests.personListErrorNotProfile);
		assertThat(personWithDtoMapper.toEntityList(null)).isEqualTo(new ArrayList<>());
	}

}
