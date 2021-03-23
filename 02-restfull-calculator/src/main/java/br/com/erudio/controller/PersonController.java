package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.data.dto.PersonDTOV2;
import br.com.erudio.service.PersonService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService services;
	
	@GetMapping
	public List<PersonDTO> findAll(){
		return services.findAll();			
	}	
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable("id") Long id) throws NotFoundException{
		return services.findById(id);
			
	}	
	
	@PostMapping
	public PersonDTO create(@RequestBody PersonDTO person){
		return services.create(person);
			
	}
	
	@PostMapping("/v2")
	public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person){
		return services.createV2(person);
			
	}
	
	@PutMapping
	public PersonDTO update(@RequestBody PersonDTO person){
		return services.update(person);
			
	}	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		 services.delete(id);			
	}	
	
	
	
	
}