package com.pragma.route.backend.person.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	private int id;
	private String name;
	private String email;
	private int cityId;
	private String cityName;
	private String imageId;
	private int profileId;
	private String profileName;
	private Date createDate;
	private Date updateDate;

}
