package com.wkt.boost.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenerationTime;

@MappedSuperclass
public class BaseModel {
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = false,
	        columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	@org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
	private Date dateCreated;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "date_modified", nullable = false,
	        columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	@org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
	private Date dateModified;
	
	
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "created_by")
	private Person createdBy;
	
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "modified_by")
	private Person modifiedBy;

	
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	
	public Person getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Person createdBy) {
		this.createdBy = createdBy;
	}

	
	public Person getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Person modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}
