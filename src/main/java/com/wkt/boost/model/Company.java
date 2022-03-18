package com.wkt.boost.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends UUIDModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;	
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "company_person", 
	joinColumns = @JoinColumn(name = "company_id"),
	inverseJoinColumns = @JoinColumn(name = "person_id"))
	private List<Person> personList;
	
	@Column(name = "name")
	private String name;	
	
	@Column(name = "address")
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private CompanyType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "business_line")
	private CompanyType businessLine;
	
	@Column(name = "base_product")
	private String baseProduct;
	
	@ManyToOne
	@JoinColumn(name = "parent_company_id")
	private Company parentCompany;
	
	public enum CompanyType {
		OWNED,REBRAND,FRANCHISE
	}
	
	public enum BusinessLine {
		FOOD
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Company getParentCompany() {
		return parentCompany;
	}
	public void setParentCompany(Company parentCompany) {
		this.parentCompany = parentCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CompanyType getType() {
		return type;
	}
	public void setType(CompanyType type) {
		this.type = type;
	}
	public CompanyType getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(CompanyType businessLine) {
		this.businessLine = businessLine;
	}
	public String getBaseProduct() {
		return baseProduct;
	}
	public void setBaseProduct(String baseProduct) {
		this.baseProduct = baseProduct;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
}
