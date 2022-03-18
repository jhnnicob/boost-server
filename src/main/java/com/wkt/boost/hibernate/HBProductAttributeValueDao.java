package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IProductAttributeValueDao;
import com.wkt.boost.model.ProductAttributeValue;

@Repository
public class HBProductAttributeValueDao extends HBBaseDao<ProductAttributeValue> implements IProductAttributeValueDao{
	
	@Override
	public Class<ProductAttributeValue> getType() {
		return ProductAttributeValue.class;
	}

}
