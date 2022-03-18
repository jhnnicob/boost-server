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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_item_ingredient")
public class OrderItemIngredient extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_item_id")
	@JsonBackReference
	private OrderItem orderitem;
	
	@ManyToOne
	@JoinColumn(name = "product_ingredient_id")
	private ProductIngredient productIngredient;
	
	@ManyToOne
	@JoinColumn(name = "use_material_id")
	private Material usedMaterial;
	
	@ManyToOne
	@JoinColumn(name = "uom_id")
	private Uom uom;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "unit_cost")
	private double unitCost; //Calculated base on material buying cost
	
	@Column(name = "unit_price")
	private double unitPrice;

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderItem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(OrderItem orderitem) {
		this.orderitem = orderitem;
	}

	public ProductIngredient getProductIngredient() {
		return productIngredient;
	}

	public void setProductIngredient(ProductIngredient productIngredient) {
		this.productIngredient = productIngredient;
	}

	public Material getUsedMaterial() {
		return usedMaterial;
	}

	public void setUsedMaterial(Material usedMaterial) {
		this.usedMaterial = usedMaterial;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
