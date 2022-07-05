package com.pragma.route.backend.person.infrastructure.controller.api;

import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonApiService personApiService;
	
	@Operation(summary = "Crear una persona")
    @ApiResponse(responseCode = "200", description = "Persona creada con exito")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto en la peticion",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "404", description = "Se mando la peticion con un recurso que no existe",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@PostMapping("/")
	public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
		return new ResponseEntity<PersonDTO>(personApiService.create(person), HttpStatus.OK);
	}

	@Operation(summary = "Actualizar una persona")
    @ApiResponse(responseCode = "200", description = "Persona actualizada con exito")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto en la peticion",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "404", description = "Se mando la peticion con un recurso que no existe",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@PutMapping("/")
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person) {
		return new ResponseEntity<PersonDTO>(personApiService.update(person), HttpStatus.OK);
	}
	
	@Operation(summary = "Consultar todas las personas")
    @ApiResponse(responseCode = "200", description = "Solicitud exitosa")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto con una persona de la lista",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        return new ResponseEntity<List<PersonDTO>>(personApiService.getAllPerson(), HttpStatus.OK);
    }

	@Operation(summary = "Consultar una persona por id")
    @ApiResponse(responseCode = "200", description = "Solicitud exitosa")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto con los datos de la persona a consultar",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable("personId") int personId){
        return new ResponseEntity<PersonDTO>(personApiService.getPersonById(personId), HttpStatus.OK);
    }
    
}
