package com.pragma.route.backend.person.domain.service.validator.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.domain.exception.conflict.format.EmailFormatException;
import com.pragma.route.backend.person.domain.exception.conflict.required.EmailRequiredException;
import com.pragma.route.backend.person.domain.exception.conflict.required.ProfileRequiredException;
import com.pragma.route.backend.person.domain.service.validator.PersonValidatorDomainService;

@SpringBootTest
public class PersonValidatorDomainServiceImplTests {
	
	private PersonValidatorDomainService personValidatorDomainService;	
	
	@BeforeEach
	public void setup() {
		personValidatorDomainService = new PersonValidatorDomainServiceImpl();
	}

	@Test
	public void validateEntityRequired() {
		assertDoesNotThrow(() -> personValidatorDomainService.validateEntityRequired(PersonDataTests.personOkToCreate));
		assertDoesNotThrow(() -> personValidatorDomainService.validateEntityRequired(PersonDataTests.personOkDontHaveCity));
		assertThrows(ProfileRequiredException.class, () -> personValidatorDomainService.validateEntityRequired(PersonDataTests.personErrorNotProfile));
		assertThrows(EmailRequiredException.class, () -> personValidatorDomainService.validateEntityRequired(PersonDataTests.personErrorNotEmail));
		assertThrows(EmailRequiredException.class, () -> personValidatorDomainService.validateEntityRequired(PersonDataTests.personErrorEmailEmpty));
	}

	@Test
	public void validateEntityFormat() {
		assertDoesNotThrow(() -> personValidatorDomainService.validateEntityFormat(PersonDataTests.personOkToCreate));
		assertDoesNotThrow(() -> personValidatorDomainService.validateEntityFormat(PersonDataTests.personOkDontHaveCity));
		assertThrows(EmailFormatException.class, () -> personValidatorDomainService.validateEntityFormat(PersonDataTests.personErrorEmailFormat));
	}

}
