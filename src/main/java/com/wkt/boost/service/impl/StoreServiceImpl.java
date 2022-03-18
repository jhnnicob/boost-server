package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.IStoreDao;
import com.wkt.boost.model.Store;
import com.wkt.boost.service.api.StoreService;

@Service
public class StoreServiceImpl extends CrudServiceImpl<Store> implements StoreService{
	
	@Autowired
	private IStoreDao storeDao;
	
	@Override
	public IBaseDao<Store> getDao() {
		return storeDao;
	}

}
