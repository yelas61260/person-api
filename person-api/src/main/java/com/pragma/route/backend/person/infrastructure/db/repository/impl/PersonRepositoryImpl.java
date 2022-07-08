package com.pragma.route.backend.person.infrastructure.db.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.route.backend.person.application.dto.PersonDto;
import com.pragma.route.backend.person.infrastructure.db.dao.PersonDao;
import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.mapper.PersonMySqlEntityWithDtoMapper;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
	
	private final PersonDao personDao;
	private final PersonMySqlEntityWithDtoMapper personMySqlEntityWithDtoMapper;

	@Override
	public List<PersonDto> getAll() {
		return personMySqlEntityWithDtoMapper.toDtoList((List<PersonMySqlEntity>) personDao.findAll());
	}

	@Override
	public PersonDto getById(int personId) {
		Optional<PersonMySqlEntity> personFind = personDao.findById(personId);
		if (personFind.isEmpty()) {
			return null;
		}else {
			return personMySqlEntityWithDtoMapper.toDto(personFind.get());
		}
	}

	@Override
	public PersonDto create(PersonDto person) {
		PersonMySqlEntity personMySqlEntity = personMySqlEntityWithDtoMapper.toMySqlEntity(person);
		return personMySqlEntityWithDtoMapper.toDto(personDao.save(personMySqlEntity));
	}

	@Override
	public PersonDto update(PersonDto person) {
		PersonMySqlEntity personMySqlEntity = personMySqlEntityWithDtoMapper.toMySqlEntity(person);
		return personMySqlEntityWithDtoMapper.toDto(personDao.save(personMySqlEntity));
	}

}
