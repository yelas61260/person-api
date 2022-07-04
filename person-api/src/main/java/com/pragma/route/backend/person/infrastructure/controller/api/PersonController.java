package com.pragma.route.backend.person.infrastructure.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.route.backend.person.application.dto.PersonDTO;
import com.pragma.route.backend.person.infrastructure.response.ResponseDTO;
import com.pragma.route.backend.person.infrastructure.service.PersonApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonApiService personApiService;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDTO> create(@RequestBody PersonDTO person) {
		ResponseDTO response = new ResponseDTO(personApiService.create(person), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDTO> update(@RequestBody PersonDTO person) {
		ResponseDTO response = new ResponseDTO(personApiService.update(person), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	    
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllPerson() {
		ResponseDTO response = new ResponseDTO(personApiService.getAllPerson(), HttpStatus.OK.value(), "success");
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<ResponseDTO> getPersonById(@PathVariable("personId") int personId){
		ResponseDTO response = new ResponseDTO(personApiService.getPersonById(personId), HttpStatus.OK.value(), "success");
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    
}
