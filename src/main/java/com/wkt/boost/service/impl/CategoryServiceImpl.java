package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.ICategoryDao;
import com.wkt.boost.model.Category;
import com.wkt.boost.service.api.CategoryService;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category> implements CategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public IBaseDao<Category> getDao() {
		return categoryDao;
	}

}
