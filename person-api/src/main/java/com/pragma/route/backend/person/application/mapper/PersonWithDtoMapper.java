package com.pragma.route.backend.person.application.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.domain.model.Person;

@Mapper
public interface PersonWithDtoMapper {
	
	PersonDTO toDto(Person entity);
	Person toEntity(PersonDTO dto);
	
	default List<PersonDTO> toDtoList(List<Person> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<Person> toEntityList(List<PersonDTO> dtos) {
		if (dtos == null) {
			return new ArrayList<>();
		}
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
