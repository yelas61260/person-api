package com.pragma.route.backend.person.infrastructure.db.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.infrastructure.db.mapper.PersonMySqlEntityWithDtoMapper;


@SpringBootTest
public class PersonMySqlEntityWithDtoMapperImplTests {
	
	private PersonMySqlEntityWithDtoMapper personMySqlEntityWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		personMySqlEntityWithDtoMapper = new PersonMySqlEntityWithDtoMapperImpl();
	}

	@Test
	public void toDto() {
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkToCreate)).isEqualTo(PersonDataTests.personDtoOkToCreate);
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkDontHaveCity)).isEqualTo(PersonDataTests.personDtoOkDontHaveCity);
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkDontHaveProfile)).isEqualTo(PersonDataTests.personDtoOkDontHaveProfile);
	}

	@Test
	public void toMySqlEntity() {
		assertThat(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personEntityOkToCreate);
		assertThat(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDataTests.personDtoOkDontHaveCity)).isEqualTo(PersonDataTests.personEntityOkDontHaveCity);
	}
	
	@Test
	public void toDtoList() {
		assertThat(personMySqlEntityWithDtoMapper.toDtoList(PersonDataTests.personEntityListOk)).isEqualTo(PersonDataTests.personDtoListOk);
		assertThat(personMySqlEntityWithDtoMapper.toDtoList(null)).isEqualTo(new ArrayList<>());
	}

}
