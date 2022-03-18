package com.wkt.boost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "inventory_uom_id")
	private Uom inventoryUom;
	
	@ManyToOne
	@JoinColumn(name = "default_sell_uom_id")
	private Uom defaultSellUom;
	
	@ManyToOne
	@JoinColumn(name = "buy_uom_id")
	private Uom buyUom;
	
	@Column(name = "buy_cost")
	private double buyCost;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Uom getInventoryUom() {
		return inventoryUom;
	}

	public void setInventoryUom(Uom inventoryUom) {
		this.inventoryUom = inventoryUom;
	}

	public Uom getDefaultSellUom() {
		return defaultSellUom;
	}

	public void setDefaultSellUom(Uom defaultSellUom) {
		this.defaultSellUom = defaultSellUom;
	}

	public Uom getBuyUom() {
		return buyUom;
	}

	public void setBuyUom(Uom buyUom) {
		this.buyUom = buyUom;
	}

	public double getBuyCost() {
		return buyCost;
	}

	public void setBuyCost(double buyCost) {
		this.buyCost = buyCost;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
