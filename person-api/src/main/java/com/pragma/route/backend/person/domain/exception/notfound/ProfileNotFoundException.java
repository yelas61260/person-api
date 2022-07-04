package com.pragma.route.backend.person.domain.exception.notfound;

public class ProfileNotFoundException extends ApiNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ProfileNotFoundException() {
		super("Profile Not Found");
	}

}
