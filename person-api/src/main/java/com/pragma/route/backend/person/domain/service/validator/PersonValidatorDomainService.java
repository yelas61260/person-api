package com.pragma.route.backend.person.domain.service.validator;

import com.pragma.route.backend.person.domain.model.Person;

public interface PersonValidatorDomainService {
	
	public void validateEntityRequired(Person person);
	public void validateEntityFormat(Person person);

}
