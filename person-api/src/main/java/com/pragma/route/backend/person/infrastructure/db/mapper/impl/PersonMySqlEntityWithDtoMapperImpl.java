package com.pragma.route.backend.person.infrastructure.db.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.route.backend.person.application.dto.PersonDto;
import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;
import com.pragma.route.backend.person.infrastructure.db.entity.CityMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.entity.ProfileMySqlEntity;
import com.pragma.route.backend.person.infrastructure.db.mapper.PersonMySqlEntityWithDtoMapper;

@Component
public class PersonMySqlEntityWithDtoMapperImpl implements PersonMySqlEntityWithDtoMapper {

	@Override
	public PersonDto toDto(PersonMySqlEntity entity) {
		return PersonDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.cityId(entity.getCityId()!=null?entity.getCityId().getId():ApiGlobalConstant.CITY_NULL_ID)
				.cityName(entity.getCityId()!=null?entity.getCityId().getName():ApiGlobalConstant.CITY_NULL_TEXT)
				.profileId(entity.getProfileId()!=null?entity.getProfileId().getId():ApiGlobalConstant.PROFILE_NULL_ID)
				.profileName(entity.getProfileId()!=null?entity.getProfileId().getName():ApiGlobalConstant.PROFILE_NULL_TEXT)
				.imageId(entity.getImageId())
				.createDate(entity.getCreateDate())
				.updateDate(entity.getUpdateDate())
				.build();
	}

	@Override
	public PersonMySqlEntity toMySqlEntity(PersonDto dto) {
		return PersonMySqlEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.cityId(
						dto.getCityId()==0
						?null
						:CityMySqlEntity.builder()
						.id(dto.getCityId())
						.name(dto.getCityName())
						.build()
						)
				.profileId(
						ProfileMySqlEntity.builder()
						.id(dto.getProfileId())
						.name(dto.getProfileName())
						.build()
						)
				.imageId(dto.getImageId())
				.createDate(dto.getCreateDate())
				.updateDate(dto.getUpdateDate())
				.build();
	}

}
