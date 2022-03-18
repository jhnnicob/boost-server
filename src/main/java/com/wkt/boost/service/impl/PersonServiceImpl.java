package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.IPersonDao;
import com.wkt.boost.model.Person;
import com.wkt.boost.service.api.PersonService;

@Service
public class PersonServiceImpl extends CrudServiceImpl<Person> implements PersonService{

	@Autowired
	private IPersonDao personDao;
	
	@Override
	public IBaseDao<Person> getDao() {
		return personDao;
	}
	
}
