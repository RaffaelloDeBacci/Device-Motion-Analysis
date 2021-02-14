package com.deepanalysis.devicemotionanalysis.common.rest.model;

import java.util.ArrayList;
import java.util.List;

public class UiMessages {
	
	private List<MetadataMessage> errors = new ArrayList<>();

	private List<MetadataMessage> infos = new ArrayList<>();

	private List<MetadataMessage> warnings = new ArrayList<>();
	
	
	public List<MetadataMessage> getErrors() {
		return errors;
	}

	public List<MetadataMessage> getInfos() {
		return infos;
	}

	public List<MetadataMessage> getWarnings() {
		return warnings;
	}
	
	
	public void setErrors(List<MetadataMessage> errors) {
		this.errors = errors;
	}
	
	public void setWarnings(List<MetadataMessage> warnings) {
		this.warnings = warnings;
	}
	
	public void setInfos(List<MetadataMessage> infos) {
		this.infos = infos;
	}
}
