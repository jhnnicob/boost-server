package com.wkt.boost.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product")
public class Product extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_product_id")
	private Product parentProduct;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ProductType type;

	@Column(name = "sku")
	private String sku;

	@Column(name = "inventory")
	private double inventory;

	@Column(name = "active")
	private boolean active;

	@Column(name = "available")
	private boolean available;

	@Column(name = "is_variation")
	private boolean isVariation;

	@OneToMany(orphanRemoval = true, cascade = { CascadeType.ALL })
	@JoinColumn(name = "product_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<ProductIngredient> productIngredientList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<ProductAttribute> attributeList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<ProductAttributeVariation> variationList;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonIgnoreProperties("productList")
	private List<Category> categoryList;

	@Column(name = "unit_price")
	private double unitPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sell_uom_id")
	private Uom sellUom;

	private List<Product> productVariationList;

	private boolean defaultVariation;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<ProductAttributeVariation> getVariationList() {
		return variationList;
	}

	public void setVariationList(List<ProductAttributeVariation> variationList) {
		this.variationList = variationList;
	}

	public enum ProductType {
		SIMPLE, WITH_VARIATION
	}

	public List<ProductAttribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ProductAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	public List<ProductIngredient> getProductIngredientList() {
		return productIngredientList;
	}

	public void setProductIngredientList(List<ProductIngredient> productIngredientList) {
		this.productIngredientList = productIngredientList;
	}

	public Product getParentProduct() {
		return parentProduct;
	}

	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	public boolean isVariation() {
		return isVariation;
	}

	public void setVariation(boolean isVariation) {
		this.isVariation = isVariation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getInventory() {
		return inventory;
	}

	public void setInventory(double inventory) {
		this.inventory = inventory;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Uom getSellUom() {
		return sellUom;
	}

	public void setSellUom(Uom sellUom) {
		this.sellUom = sellUom;
	}

	public List<Product> getProductVariationList() {
		return productVariationList;
	}

	public void setProductVariationList(List<Product> productVariationList) {
		this.productVariationList = productVariationList;
	}

	public boolean isDefaultVariation() {
		return defaultVariation;
	}

	public void setDefaultVariation(boolean defaultVariation) {
		this.defaultVariation = defaultVariation;
	}

}
