package com.pragma.route.backend.person.infrastructure.db.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDtoDataTests;
import com.pragma.route.backend.person.PersonEntityDataTests;
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
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkToCreate)).isEqualTo(PersonDtoDataTests.personOkToCreate);
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkDontHaveCity)).isEqualTo(PersonDtoDataTests.personOkDontHaveCity);
		assertThat(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkDontHaveProfile)).isEqualTo(PersonDtoDataTests.personOkDontHaveProfile);
	}

	@Test
	public void toMySqlEntity() {
		assertThat(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDtoDataTests.personOkToCreate)).isEqualTo(PersonEntityDataTests.personOkToCreate);
		assertThat(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDtoDataTests.personOkDontHaveCity)).isEqualTo(PersonEntityDataTests.personOkDontHaveCity);
	}
	
	@Test
	public void toDtoList() {
		assertThat(personMySqlEntityWithDtoMapper.toDtoList(PersonEntityDataTests.personListOk)).isEqualTo(PersonDtoDataTests.personListOk);
		assertThat(personMySqlEntityWithDtoMapper.toDtoList(null)).isEqualTo(new ArrayList<>());
	}

}
