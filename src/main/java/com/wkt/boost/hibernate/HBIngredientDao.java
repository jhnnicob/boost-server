package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IIngredientDao;
import com.wkt.boost.model.Ingredient;

@Repository
public class HBIngredientDao extends HBBaseDao<Ingredient> implements IIngredientDao{
	
	@Override
	public Class<Ingredient> getType() {
		return Ingredient.class;
	}

}
