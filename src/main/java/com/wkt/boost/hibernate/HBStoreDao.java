package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IStoreDao;
import com.wkt.boost.model.Store;

@Repository
public class HBStoreDao extends HBBaseDao<Store> implements IStoreDao{
	
	@Override
	public Class<Store> getType() {
		return Store.class;
	}

}
