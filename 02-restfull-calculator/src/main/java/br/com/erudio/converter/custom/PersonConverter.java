package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.dto.PersonDTOV2;
import br.com.erudio.data.model.Person;

@Service
public class PersonConverter {
	
	public PersonDTOV2 convertEntityToDTO(Person person) {
		PersonDTOV2 vo = new PersonDTOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGenre(person.getGenre());
		return vo;
	}
	
	public Person convertDTOtoEntity(PersonDTOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGenre(person.getGenre());
		return entity;
	}

}
