package com.pragma.route.backend.person.domain.exception.notfound;

public class CityNotFoundException extends ApiNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public CityNotFoundException() {
		super("City Not found");
	}

}
