package com.pragma.route.backend.person;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.domain.constant.ApiGlobalConstant;

@SpringBootTest
public class ApiGlobalConstantTests {
	
	private ApiGlobalConstant apiGlobalConstant;
	
	@BeforeEach
	public void setup() {
		apiGlobalConstant = new ApiGlobalConstant();
	}
	
	@Test
	public void validateConstant() {
		assertTrue(apiGlobalConstant.VALIDATE_EMAIL_REGEX.equals("^[A-Za-z0-9.]+@[A-Za-z]+.[A-Za-z]+(.[A-Za-z]+)*$"));
		assertTrue(apiGlobalConstant.CITY_NULL_ID == 0);
		assertTrue(apiGlobalConstant.CITY_NULL_TEXT.equals("N/A"));
		assertTrue(apiGlobalConstant.PROFILE_NULL_ID == 0);
		assertTrue(apiGlobalConstant.PROFILE_NULL_TEXT.equals("N/A"));
		assertTrue(apiGlobalConstant.ID_TO_CREATE_PERSON == 0);
	}

}
