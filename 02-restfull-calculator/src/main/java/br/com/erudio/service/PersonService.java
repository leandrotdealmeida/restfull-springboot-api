package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.data.model.Person;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;
import javassist.NotFoundException;

@Service
public class PersonService {

//	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonRepository personRepository;

	public PersonDTO create(PersonDTO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonDTO.class);
		return vo;
	}
	
	public List<PersonDTO> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(),PersonDTO.class);
	}

	public PersonDTO findById(Long id) throws NotFoundException {
		var entity =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return DozerConverter.parseObject(entity,PersonDTO.class);
		
		
	}
	
	public PersonDTO update(PersonDTO person) {
		 var entity = personRepository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		 
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGenre(person.getGenre());
		
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonDTO.class);
		
		return vo;
	}

	public void delete(Long id) {
		 Person entity = personRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personRepository.delete(entity);

	}

//	private Person mockPerson(int i) {
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Person Name " + i);
//		person.setLastName("Last name " + i);
//		person.setAddress("Some address in Brasil " + i);
//		person.setGenre("Male");
//		return person;
//	}

}
