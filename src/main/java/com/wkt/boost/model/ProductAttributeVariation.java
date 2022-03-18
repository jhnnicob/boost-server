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
@Table(name = "product_attribute_variation")
public class ProductAttributeVariation extends BaseModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "product_attribute_id")
	private ProductAttribute productAttribute;
	
	@ManyToOne
	@JoinColumn(name = "product_attribute_value_id")
	private ProductAttributeValue value;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductAttribute getProductAttribute() {
		return productAttribute;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}

	public ProductAttributeValue getValue() {
		return value;
	}

	public void setValue(ProductAttributeValue value) {
		this.value = value;
	}

}
