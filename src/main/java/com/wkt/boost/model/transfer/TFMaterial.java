package com.wkt.boost.model.transfer;

import org.modelmapper.ModelMapper;

import com.wkt.boost.model.Material;
import com.wkt.boost.model.UUIDModel;

public class TFMaterial extends TFUUIDModel {

	private String sku;
	private String name;
	private String description;
	private double cost;
	
	@Override
	public <D extends TFUUIDModel, S extends UUIDModel> D newFrom(S source, Class<?> destination) {
		if (source == null) {
			return null;
		}else {
			ModelMapper mapper = new ModelMapper();
			D obj = (D) mapper.map(source, destination);
			return obj;
		}
	}
	
	public TFMaterial newFrom(Material source) {
		if (source == null) {
			return null;
		}else {
			ModelMapper mapper = new ModelMapper();
			TFMaterial obj = mapper.map(source, TFMaterial.class);
			return obj;
		}
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
