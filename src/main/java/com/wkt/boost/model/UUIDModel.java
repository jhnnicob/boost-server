package com.wkt.boost.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UUIDModel extends BaseModel {

	@Column(name = "uuid")
	private String uuId;
	
	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	
}
