package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.IProductDao;
import com.wkt.boost.model.Product;
import com.wkt.boost.service.api.ProductService;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product> implements ProductService{
	
	@Autowired
	IProductDao productDao;
	
	@Override
	public IBaseDao<Product> getDao() {
		return productDao;
	}

}
