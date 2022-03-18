package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IProductDao;
import com.wkt.boost.model.Product;

@Repository
public class HBProductDao extends HBBaseDao<Product> implements IProductDao{
	
	@Override
	public Class<Product> getType() {
		return Product.class;
	}

}
