package com.pragma.route.backend.person.domain.exception.conflict.format;

import com.pragma.route.backend.person.domain.exception.conflict.ApiConflictException;

public class EmailFormatException extends ApiConflictException {

	private static final long serialVersionUID = 1L;
	
	public EmailFormatException() {
		super("Email format exception");
	}

}
