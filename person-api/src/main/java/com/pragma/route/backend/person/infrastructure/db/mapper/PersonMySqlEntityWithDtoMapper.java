package com.pragma.route.backend.person.infrastructure.db.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.pragma.route.backend.person.application.dto.PersonDto;
import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;

@Mapper
public interface PersonMySqlEntityWithDtoMapper {
	
	PersonDto toDto(PersonMySqlEntity entity);
	PersonMySqlEntity toMySqlEntity(PersonDto dto);
	
	default List<PersonDto> toDtoList(List<PersonMySqlEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

}
