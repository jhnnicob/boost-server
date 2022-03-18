package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IPersonDao;
import com.wkt.boost.model.Person;

@Repository
public class HBPersonDao extends HBBaseDao<Person> implements IPersonDao{

	@Override
	public Class<Person> getType() {
		return Person.class;
	}

}
