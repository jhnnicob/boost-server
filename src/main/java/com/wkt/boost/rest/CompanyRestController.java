package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Company;
import com.wkt.boost.service.api.CompanyService;
import com.wkt.boost.service.api.CrudService;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController extends CrudRestController<Company> {

	@Autowired
	private CompanyService companyService;
	
	@Override
	public CrudService<Company> getService() {
		return companyService;
	}
}
