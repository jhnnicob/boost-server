package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IMaterialDao;
import com.wkt.boost.model.Material;

@Repository
public class HBMaterialDao extends HBBaseDao<Material> implements IMaterialDao{

	@Override
	public Class<Material> getType() {
		return Material.class;
	}

}
