package com.wkt.boost.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_item")
public class OrderItem extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "quantity")
	private double quantity;
	
	@ManyToOne
	@JoinColumn(name = "uom_id")
	private Uom uom;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "receipt_description")
	private String receiptDescription;
	
	@ManyToOne
	@JoinColumn(name = "discount_id")
	private Discount discount;
	
	@Column(name = "discount_rate")
	private double discountRate;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_item_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<OrderItemIngredient> orderIngredientList;

	public List<OrderItemIngredient> getOrderIngredientList() {
		return orderIngredientList;
	}

	public void setOrderIngredientList(List<OrderItemIngredient> orderIngredientList) {
		this.orderIngredientList = orderIngredientList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getReceiptDescription() {
		return receiptDescription;
	}

	public void setReceiptDescription(String receiptDescription) {
		this.receiptDescription = receiptDescription;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

}
