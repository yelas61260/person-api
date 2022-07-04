package com.pragma.route.backend.person.domain.exception.conflict.required;

import com.pragma.route.backend.person.domain.exception.conflict.ApiConflictException;

public class EmailRequiredException extends ApiConflictException {

	private static final long serialVersionUID = 1L;
	
	public EmailRequiredException() {
		super("Email is required");
	}

}
