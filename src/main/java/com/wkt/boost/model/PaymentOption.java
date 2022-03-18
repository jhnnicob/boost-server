package com.wkt.boost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_option")
public class PaymentOption extends UUIDModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tenderded")
	private boolean tenderded;

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

	public boolean isTenderded() {
		return tenderded;
	}

	public void setTenderded(boolean tenderded) {
		this.tenderded = tenderded;
	}
}
