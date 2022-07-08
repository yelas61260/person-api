package com.pragma.route.backend.person.application.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String name;
	protected String email;
	protected int cityId;
	protected String cityName;
	protected String imageId;
	@NotBlank
	protected int profileId;
	protected String profileName;
	protected Date createDate;
	protected Date updateDate;
	
	public PersonDto clone() {
		return PersonDto.builder()
				.id(id)
				.name(name)
				.email(email)
				.cityId(cityId)
				.cityName(cityName)
				.imageId(imageId)
				.profileId(profileId)
				.profileName(profileName)
				.createDate(createDate)
				.updateDate(updateDate)
				.build();
	}

}
