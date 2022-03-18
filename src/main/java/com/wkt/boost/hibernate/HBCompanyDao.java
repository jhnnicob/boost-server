package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.ICompanyDao;
import com.wkt.boost.model.Company;

@Repository
public class HBCompanyDao extends HBBaseDao<Company> implements ICompanyDao {
	@Override
	public Class<Company> getType() {
		return Company.class;
	}
}
