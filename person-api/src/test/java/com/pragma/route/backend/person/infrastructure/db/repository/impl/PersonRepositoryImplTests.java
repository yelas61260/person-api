package com.pragma.route.backend.person.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.infrastructure.db.dao.PersonDao;
import com.pragma.route.backend.person.infrastructure.db.mapper.PersonMySqlEntityWithDtoMapper;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;

@SpringBootTest
public class PersonRepositoryImplTests {
	
	private PersonRepository personRepository;
	
	@Mock
	private PersonDao personDao;
	
	@Mock
	private PersonMySqlEntityWithDtoMapper personMySqlEntityWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		personRepository = new PersonRepositoryImpl(personDao, personMySqlEntityWithDtoMapper);		

		Mockito.when(personDao.findAll()).thenReturn(PersonDataTests.personEntityListOk);
		Mockito.when(personDao.findById(0)).thenReturn(Optional.empty());
		Mockito.when(personDao.findById(1)).thenReturn(Optional.of(PersonDataTests.personEntityOkCreated));
		Mockito.when(personDao.save(PersonDataTests.personEntityOkToCreate)).thenReturn(PersonDataTests.personEntityOkCreated);
		Mockito.when(personDao.save(PersonDataTests.personEntityOkCreated)).thenReturn(PersonDataTests.personEntityOkUpdated);		

		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkToCreate)).thenReturn(PersonDataTests.personDtoOkToCreate);
		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkCreated)).thenReturn(PersonDataTests.personDtoOkCreated);
		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonDataTests.personEntityOkUpdated)).thenReturn(PersonDataTests.personDtoOkUpdated);		
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDataTests.personDtoOkToCreate)).thenReturn(PersonDataTests.personEntityOkToCreate);
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDataTests.personDtoOkCreated)).thenReturn(PersonDataTests.personEntityOkCreated);
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDataTests.personDtoOkUpdated)).thenReturn(PersonDataTests.personEntityOkUpdated);	
		Mockito.when(personMySqlEntityWithDtoMapper.toDtoList(PersonDataTests.personEntityListOk)).thenReturn(PersonDataTests.personDtoListOk);
	}

	@Test
	public void getAll() {
		assertThat(personRepository.getAll()).isEqualTo(PersonDataTests.personDtoListOk);
	}

	@Test
	public void getById() {
		assertThat(personRepository.getById(0)).isEqualTo(null);
		assertThat(personRepository.getById(1)).isEqualTo(PersonDataTests.personDtoOkCreated);
	}

	@Test
	public void create() {
		assertThat(personRepository.create(PersonDataTests.personDtoOkToCreate)).isEqualTo(PersonDataTests.personDtoOkCreated);
	}

	@Test
	public void update() {
		assertThat(personRepository.update(PersonDataTests.personDtoOkCreated)).isEqualTo(PersonDataTests.personDtoOkUpdated);
	}

}
