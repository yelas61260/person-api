package com.pragma.route.backend.person.domain.exception.conflict;

import com.pragma.route.backend.person.domain.exception.ApiException;

public class ApiConflictException extends ApiException {

	private static final long serialVersionUID = 1L;
	
	public ApiConflictException(String message) {
		super(message);
	}

}
