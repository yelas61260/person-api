package com.pragma.route.backend.person.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.person.domain.service.impl.PersonDomainServiceImpl;
import com.pragma.route.backend.person.domain.service.validator.PersonValidatorDomainService;
import com.pragma.route.backend.person.domain.service.validator.impl.PersonValidatorDomainServiceImpl;

@Configuration
public class BeanDomainConfiguration {
	
	@Bean
	public PersonDomainServiceImpl personDomainService(PersonValidatorDomainService personValidatorDomainService) {
		return new PersonDomainServiceImpl(personValidatorDomainService);
	}
	
	@Bean
	public PersonValidatorDomainServiceImpl personValidatorDomainService() {
		return new PersonValidatorDomainServiceImpl();
	}

}
