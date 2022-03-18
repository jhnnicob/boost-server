package com.wkt.boost.dao;

import com.wkt.boost.model.ProductAttribute;

public interface IProductAttributeDao extends IBaseDao<ProductAttribute>{
	
	@Override
	default Class<ProductAttribute> getType() {
		return ProductAttribute.class;
	}

}
