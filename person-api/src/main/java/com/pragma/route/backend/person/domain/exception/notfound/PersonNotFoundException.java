package com.pragma.route.backend.person.domain.exception.notfound;

public class PersonNotFoundException extends ApiNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException() {
		super("Person Not Found");
	}

}
