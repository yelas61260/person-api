package com.pragma.route.backend.person.domain.exception.conflict.required;

import com.pragma.route.backend.person.domain.exception.conflict.ApiConflictException;

public class ProfileRequiredException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfileRequiredException() {
		super("Profile is required");
	}

}
