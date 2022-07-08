package com.pragma.route.backend.person.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonWithImageDto extends PersonDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String imageBodyBase64;
	
	public PersonWithImageDto(PersonDto personDto) {
		id = personDto.getId();
		name = personDto.getName();
		email = personDto.getEmail();
		cityId = personDto.getCityId();
		cityName = personDto.getCityName();
		imageId = personDto.getImageId();
		profileId = personDto.getProfileId();
		profileName = personDto.getProfileName();
		createDate = personDto.getCreateDate();
		updateDate = personDto.getUpdateDate();
	}

}
