package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Person;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.service.api.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonRestController extends CrudRestController<Person>{
	
	@Autowired
	private PersonService personService;
	
	@Override
	public CrudService<Person> getService() {
		return personService;
	}

}
