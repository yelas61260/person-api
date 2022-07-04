package com.pragma.route.backend.person.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.person.application.service.PersonService;
import com.pragma.route.backend.person.infrastructure.db.repository.CityRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.PersonRepository;
import com.pragma.route.backend.person.infrastructure.db.repository.ProfileRepository;
import com.pragma.route.backend.person.infrastructure.service.impl.PersonApiServiceImpl;

@Configuration
public class BeanInfrastructureConfiguration {
	
	@Bean
	public PersonApiServiceImpl personApiServiceImpl(PersonRepository personRepository, CityRepository cityRepository, ProfileRepository profileRepository, PersonService personService) {
		return new PersonApiServiceImpl(personRepository, cityRepository, profileRepository, personService);
	}

}
