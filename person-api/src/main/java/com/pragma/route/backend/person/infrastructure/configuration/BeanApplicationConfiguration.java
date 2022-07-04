package com.pragma.route.backend.person.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.person.application.mapper.PersonWithDtoMapper;
import com.pragma.route.backend.person.application.mapper.impl.PersonWithDtoMapperImpl;
import com.pragma.route.backend.person.application.service.impl.PersonServiceImpl;
import com.pragma.route.backend.person.domain.service.PersonDomainService;

@Configuration
public class BeanApplicationConfiguration {
	
	@Bean
	public PersonServiceImpl personServiceImpl(PersonDomainService personDomainService, PersonWithDtoMapper personWithDtoMapper) {
		return new PersonServiceImpl(personDomainService, personWithDtoMapper);
	}
	
	@Bean
	public PersonWithDtoMapperImpl personWithDtoMapper() {
		return new PersonWithDtoMapperImpl();
	}

}
