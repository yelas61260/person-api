package com.pragma.route.backend.person.domain.service.validator.impl;

import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.model.Person;
import com.pragma.route.backend.person.domain.service.validator.PersonValidatorDomainService;

public class PersonValidatorDomainServiceImpl implements PersonValidatorDomainService {

	@Override
	public void validateEntityRequired(Person person) {
		if(person.getProfileId() == ApiGlobalConstant.PROFILE_NULL_ID) {
			throw new ProfileRequiredException();
		}
		if (person.getEmail() == null || person.getEmail().isEmpty()) {
			throw new EmailRequiredException();
		}
	}

	@Override
	public void validateEntityFormat(Person person) {
		if (!person.getEmail().matches(ApiGlobalConstant.VALIDATE_EMAIL_REGEX)) {
			throw new EmailFormatException();
		}
	}

}
