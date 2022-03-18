package com.wkt.boost.model.transfer;

import java.util.List;

import com.wkt.boost.model.Company;
import com.wkt.boost.model.Company.CompanyType;
import com.wkt.boost.model.Person;

public class TFCompany extends TFUUIDModel{

	private List<Person> personList;
	private String name;	
	private String address;
	private CompanyType type;
	private CompanyType businessLine;
	private String baseProduct;
	private Company parentCompany;
	
}
