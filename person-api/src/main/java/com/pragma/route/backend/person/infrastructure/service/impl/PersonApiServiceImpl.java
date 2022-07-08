package com.pragma.route.backend.person.infrastructure.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.person.application.dto.PersonDto;
import com.pragma.route.backend.person.application.dto.PersonWithImageDto;
import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.domain.exception.notfound.CityNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.PersonNotFoundException;
import com.pragma.route.backend.person.domain.exception.notfound.ProfileNotFoundException;
import com.pragma.route.backend.person.infrastructure.client.image.entity.ImageEntity;
import com.pragma.route.backend.person.infrastructure.client.image.service.ImageApiService;
import com.pragma.route.backend.person.infrastructure.db.repository.CityRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.ProfileRepository;
import com.pragma.route.backend.person.infrastructure.service.PersonApiService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonApiServiceImpl implements PersonApiService {
	
	private final PersonRepository personRepository;
	private final CityRepository cityRepository;
	private final ProfileRepository profileRepository;
	private final PersonService personService;
	private final ImageApiService imageApiService;

	@Override
	public PersonDto create(PersonDto personDto, MultipartFile imageFile) {
		PersonDto personDtoResponse = personDto.clone();
		personDtoResponse = personService.prepareToCreate(personDtoResponse);
		if (personDtoResponse.getCityId() != 0 && !cityRepository.exist(personDtoResponse.getCityId())) {
			throw new CityNotFoundException();
		}
		if (personDtoResponse.getProfileId() != 0 && !profileRepository.exist(personDtoResponse.getProfileId())) {
			throw new ProfileNotFoundException();
		}		
		if (imageFile != null) {
			personDtoResponse = this.addImageToPerson(personDtoResponse, imageFile);
		}
		personDtoResponse = personRepository.create(personDtoResponse);
		
		return personDtoResponse;
	}

	@Override
	public PersonDto update(PersonDto personDto, MultipartFile imageFile) {
		PersonDto personDtoResponse = personDto.clone();
		personDtoResponse = personService.prepareToUpdate(personDtoResponse);
		if (personDtoResponse.getCityId() != 0 && !cityRepository.exist(personDtoResponse.getCityId())) {
			throw new CityNotFoundException();
		}
		if (personDtoResponse.getProfileId() != 0 && !profileRepository.exist(personDtoResponse.getProfileId())) {
			throw new ProfileNotFoundException();
		}
		
		if (imageFile != null) {
			personDtoResponse = this.addImageToPerson(personDtoResponse, imageFile);
		}
		personDtoResponse = personRepository.update(personDtoResponse);
		
		return personDtoResponse;
	}

	@Override
	public List<PersonDto> getAllPerson() {
		List<PersonDto> personsDTO = personRepository.getAll();
		return personService.processPersonListToRead(personsDTO);
	}

	@Override
	public PersonDto getPersonById(int personId) {
		PersonDto personDtoResponse = personRepository.getById(personId);		
		if (personDtoResponse == null) {
			throw new PersonNotFoundException();
		}
		personDtoResponse = personDtoResponse.clone();
		personDtoResponse = personService.processPerson(personDtoResponse);
		personDtoResponse = this.findImageToPerson(personDtoResponse);
		return personDtoResponse;
	}
	
	private PersonWithImageDto addImageToPerson(PersonDto personDTO, MultipartFile imageFile) {
		PersonWithImageDto personDtoResponse = new PersonWithImageDto(personDTO);
		String imageBase64 = imageApiService.getImageBase64(personDtoResponse.getImageId());
		ImageEntity imageEntity;
		if (imageBase64 == null) {
			imageEntity = imageApiService.create(imageFile);
		} else {
			imageEntity = imageApiService.update(personDtoResponse.getImageId(), imageFile);
		}
		personDtoResponse.setImageId(imageEntity.getImageId());
		personDtoResponse.setImageBodyBase64(imageEntity.getImageBase64());
		return personDtoResponse;
	}
	
	private PersonWithImageDto findImageToPerson(PersonDto personDTO) {
		PersonWithImageDto personDtoResponse = new PersonWithImageDto(personDTO);
		String imageBase64 = imageApiService.getImageBase64(personDtoResponse.getImageId());
		personDtoResponse.setImageBodyBase64(imageBase64);
		return personDtoResponse;
	}

}
