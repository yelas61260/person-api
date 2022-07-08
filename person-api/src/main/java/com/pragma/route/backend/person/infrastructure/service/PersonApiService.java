package com.pragma.route.backend.person.infrastructure.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.person.application.dto.PersonDto;

public interface PersonApiService {
	
	public PersonDto create(PersonDto person, MultipartFile imageFile);
	public PersonDto update(PersonDto person, MultipartFile imageFile);
    public List<PersonDto> getAllPerson();
    public PersonDto getPersonById(int personId);

}
