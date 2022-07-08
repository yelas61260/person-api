package com.pragma.route.backend.person.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDtoDataTests;
import com.pragma.route.backend.person.PersonEntityDataTests;
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

		Mockito.when(personDao.findAll()).thenReturn(PersonEntityDataTests.personListOk);
		Mockito.when(personDao.findById(0)).thenReturn(Optional.empty());
		Mockito.when(personDao.findById(1)).thenReturn(Optional.of(PersonEntityDataTests.personOkCreated));
		Mockito.when(personDao.save(PersonEntityDataTests.personOkToCreate)).thenReturn(PersonEntityDataTests.personOkCreated);
		Mockito.when(personDao.save(PersonEntityDataTests.personOkCreated)).thenReturn(PersonEntityDataTests.personOkUpdated);		

		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkToCreate)).thenReturn(PersonDtoDataTests.personOkToCreate);
		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkCreated)).thenReturn(PersonDtoDataTests.personOkCreated);
		Mockito.when(personMySqlEntityWithDtoMapper.toDto(PersonEntityDataTests.personOkUpdated)).thenReturn(PersonDtoDataTests.personOkUpdated);		
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDtoDataTests.personOkToCreate)).thenReturn(PersonEntityDataTests.personOkToCreate);
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDtoDataTests.personOkCreated)).thenReturn(PersonEntityDataTests.personOkCreated);
		Mockito.when(personMySqlEntityWithDtoMapper.toMySqlEntity(PersonDtoDataTests.personOkUpdated)).thenReturn(PersonEntityDataTests.personOkUpdated);	
		Mockito.when(personMySqlEntityWithDtoMapper.toDtoList(PersonEntityDataTests.personListOk)).thenReturn(PersonDtoDataTests.personListOk);
	}

	@Test
	public void getAll() {
		assertThat(personRepository.getAll()).isEqualTo(PersonDtoDataTests.personListOk);
	}

	@Test
	public void getById() {
		assertThat(personRepository.getById(0)).isEqualTo(null);
		assertThat(personRepository.getById(1)).isEqualTo(PersonDtoDataTests.personOkCreated);
	}

	@Test
	public void create() {
		assertThat(personRepository.create(PersonDtoDataTests.personOkToCreate)).isEqualTo(PersonDtoDataTests.personOkCreated);
	}

	@Test
	public void update() {
		assertThat(personRepository.update(PersonDtoDataTests.personOkCreated)).isEqualTo(PersonDtoDataTests.personOkUpdated);
	}

}
