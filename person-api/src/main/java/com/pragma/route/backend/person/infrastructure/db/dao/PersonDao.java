package com.pragma.route.backend.person.infrastructure.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;

public interface PersonDao extends CrudRepository<PersonMySqlEntity, Integer> {

}
