package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.IMaterialDao;
import com.wkt.boost.model.Material;
import com.wkt.boost.service.api.MaterialService;

@Service
public class MaterialServiceImpl extends CrudServiceImpl<Material> implements MaterialService{

	@Autowired
	private IMaterialDao materialDao;
	
	@Override
	public IBaseDao<Material> getDao() {
		return materialDao;
	}
}
