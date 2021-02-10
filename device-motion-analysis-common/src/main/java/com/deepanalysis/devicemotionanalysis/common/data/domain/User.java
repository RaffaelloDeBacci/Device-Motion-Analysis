package com.deepanalysis.devicemotionanalysis.common.data.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;

@Document(collection="user")
public class User extends AuditableEntity {
	
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
