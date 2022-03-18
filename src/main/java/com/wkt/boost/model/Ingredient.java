package com.wkt.boost.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ingredient")
public class Ingredient extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "default_material_id")
	private Material defaultMaterial;

	@Column(name = "customizable")
	private boolean customizable;

	@OneToMany(orphanRemoval = true, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ingredient_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<IngredientMaterial> ingredientMaterialList; //TODO: Change to Ingredient material add price

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

	public Material getDefaultMaterial() {
		return defaultMaterial;
	}

	public void setDefaultMaterial(Material defaultMaterial) {
		this.defaultMaterial = defaultMaterial;
	}

	public boolean isCustomizable() {
		return customizable;
	}

	public void setCustomizable(boolean customizable) {
		this.customizable = customizable;
	}

	public List<IngredientMaterial> getIngredientMaterialList() {
		return ingredientMaterialList;
	}

	public void setIngredientMaterialList(List<IngredientMaterial> ingredientMaterialList) {
		this.ingredientMaterialList = ingredientMaterialList;
	} 

}
