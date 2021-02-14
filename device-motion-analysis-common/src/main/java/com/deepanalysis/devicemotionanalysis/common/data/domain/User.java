package com.deepanalysis.devicemotionanalysis.common.data.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;
import com.deepanalysis.devicemotionanalysis.common.security.Role;

@Document(collection="user")
public class User extends AuditableEntity {
	
	private String firstName;
	private String lastName;
	private Role role;
	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
