package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.ICategoryDao;
import com.wkt.boost.model.Category;

@Repository
public class HBCategory extends HBBaseDao<Category> implements ICategoryDao{
	
	@Override
	public Class<Category> getType() {
		return Category.class;
	}

}
