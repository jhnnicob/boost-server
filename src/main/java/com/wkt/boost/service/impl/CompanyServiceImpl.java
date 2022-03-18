package com.wkt.boost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.ICompanyDao;
import com.wkt.boost.model.Company;
import com.wkt.boost.service.api.CompanyService;

@Service
public class CompanyServiceImpl extends CrudServiceImpl<Company> implements CompanyService{

	@Autowired
	private ICompanyDao companyDao;
	
	@Override
	public IBaseDao<Company> getDao() {
		return companyDao;
	}
	
}
