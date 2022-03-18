package com.wkt.boost.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product_ingredient")
public class ProductIngredient extends UUIDModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@ManyToOne
	@JoinColumn(name = "default_material_id")
	private Material defaultMaterial;

	@ManyToOne
	@JoinColumn(name = "sell_uom_id")
	private Uom sellUom;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "optional")
	private boolean optional;
	
	@Column(name = "hide_in_order")
	private boolean hideInOrder;
	
	
	public Uom getSellUom() {
		return sellUom;
	}

	public void setSellUom(Uom sellUom) {
		this.sellUom = sellUom;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public boolean isHideInOrder() {
		return hideInOrder;
	}

	public void setHideInOrder(boolean hideInOrder) {
		this.hideInOrder = hideInOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Material getDefaultMaterial() {
		return defaultMaterial;
	}

	public void setDefaultMaterial(Material defaultMaterial) {
		this.defaultMaterial = defaultMaterial;
	}
}
