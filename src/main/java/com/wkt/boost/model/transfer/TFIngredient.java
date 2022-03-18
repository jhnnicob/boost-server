package com.wkt.boost.model.transfer;

import java.util.List;

public class TFIngredient extends TFUUIDModel {

	private String name;
	private String defaultMaterial;
	private boolean customizable;
	private List<String> materialList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultMaterial() {
		return defaultMaterial;
	}

	public void setDefaultMaterial(String defaultMaterial) {
		this.defaultMaterial = defaultMaterial;
	}

	public boolean isCustomizable() {
		return customizable;
	}

	public void setCustomizable(boolean customizable) {
		this.customizable = customizable;
	}

	public List<String> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<String> materialList) {
		this.materialList = materialList;
	}

}
