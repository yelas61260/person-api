package com.pragma.route.backend.person.infrastructure.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.route.backend.person.infrastructure.db.entity.CityMySqlEntity;

public interface CityDao extends CrudRepository<CityMySqlEntity, Integer> {

}
