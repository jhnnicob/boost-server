package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.IIngredientDao;
import com.wkt.boost.model.Ingredient;
import com.wkt.boost.service.api.IngredientService;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient> implements IngredientService{
	
	@Autowired
	private IIngredientDao ingredientDao;
	
	@Override
	public IBaseDao<Ingredient> getDao() {
		return ingredientDao;
	}

}
