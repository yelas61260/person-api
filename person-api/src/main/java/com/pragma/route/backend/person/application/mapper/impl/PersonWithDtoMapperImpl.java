package com.pragma.route.backend.person.application.mapper.impl;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.application.mapper.PersonWithDtoMapper;
import com.pragma.route.backend.person.domain.model.Person;

public class PersonWithDtoMapperImpl implements PersonWithDtoMapper {

	@Override
	public PersonDTO toDto(Person entity) {
		return PersonDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.imageId(entity.getImageId())
				.cityId(entity.getCityId())
				.cityName(entity.getCityName())
				.profileId(entity.getProfileId())
				.profileName(entity.getProfileName())
				.createDate(entity.getCreateDate())
				.updateDate(entity.getUpdateDate())
				.build();
	}

	@Override
	public Person toEntity(PersonDTO dto) {
		return Person.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.imageId(dto.getImageId())
				.cityId(dto.getCityId())
				.cityName(dto.getCityName())
				.profileId(dto.getProfileId())
				.profileName(dto.getProfileName())
				.createDate(dto.getCreateDate())
				.updateDate(dto.getUpdateDate())
				.build();
	}

}
