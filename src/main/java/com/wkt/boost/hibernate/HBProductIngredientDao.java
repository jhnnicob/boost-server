package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IProductIngredient;
import com.wkt.boost.model.ProductIngredient;

@Repository
public class HBProductIngredientDao extends HBBaseDao<ProductIngredient> implements IProductIngredient{
	
	@Override
	public Class<ProductIngredient> getType() {
		return ProductIngredient.class;
	}

}
