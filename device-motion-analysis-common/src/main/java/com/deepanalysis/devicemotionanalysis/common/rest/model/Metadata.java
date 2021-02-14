package com.deepanalysis.devicemotionanalysis.common.rest.model;

import java.util.HashMap;


public class Metadata {
	
	private UiMessages uiMessages = new UiMessages();
	
	public UiMessages getUiMessages() {
		return uiMessages;
	}
	
	

	public HashMap<String,Object> getExtendedPagination() {
		if (extendedPagination == null) {
			extendedPagination = new HashMap<String,Object>();
		}
		return extendedPagination;
	}



	public void setExtendedPagination(HashMap<String,Object> extendedPagination) {
		this.extendedPagination = extendedPagination;
	}



	private HashMap<String,Object> extendedPagination;

	
}
