package com.deepanalysis.devicemotionanalysis.common.data.domain.support;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

public abstract class AuditableEntity {
	
	private String _id;
	
	@CreatedDate
	@Indexed
	private Date createdOn;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	@Indexed
	private Date modifiedOn;
	
	@LastModifiedBy
	private String modifiedBy;

	public String getId() {
		return _id;
	}
	
	public void setId(String _id) {
		this._id = _id;		
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCollectionDB()  {
		return "";
	}				
}
