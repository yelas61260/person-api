package com.pragma.route.backend.person.domain.exception.notfound;

import com.pragma.route.backend.person.domain.exception.ApiException;

public class ApiNotFoundException extends ApiException {
	
	private static final long serialVersionUID = 1L;
	
	public ApiNotFoundException(String message) {
		super(message);
	}

}
