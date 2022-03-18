package com.wkt.boost.model.transfer;

import com.wkt.boost.model.UUIDModel;

public class TFUUIDModel extends TFBaseModel{
		
	private String uuId;
	
	public <D extends TFUUIDModel, S extends UUIDModel> D newFrom(S source, Class<?> destination) {
		return null;
	}
	
	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}
	
	
	
}
