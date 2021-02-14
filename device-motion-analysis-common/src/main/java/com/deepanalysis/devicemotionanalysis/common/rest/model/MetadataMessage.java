package com.deepanalysis.devicemotionanalysis.common.rest.model;


public class MetadataMessage {

	private String code;

	private String message;

	private MetadataMessageType type;
	
	private String description;
	
	private String fieldId;
	
	private TargetMessageAPI target;
	
	
	
	
	public static MetadataMessage errorInstance(String message, String code) {
		return new MetadataMessage(message, MetadataMessageType.ERROR, code);
	}
	
	public static MetadataMessage errorInstance(String message) {
		return errorInstance(message, "0");
	}

	public static MetadataMessage warningInstance(String message, String code) {
		return new MetadataMessage(message, MetadataMessageType.WARNING, code);
	}
	
	public static MetadataMessage warningInstance(String message) {
		return warningInstance(message, "0");
	}

	public static MetadataMessage infoInstance(String message, String code) {
		return new MetadataMessage(message, MetadataMessageType.INFO, code);
	}
	
	public static MetadataMessage infoInstance(String message) {
		return infoInstance(message, "0");
	}

	public MetadataMessage(String message, MetadataMessageType type, String code) {
		this.type = type;
		this.message = message;
		this.code = code;
	}
	
	public MetadataMessage(String message, MetadataMessageType type, String code, String fieldId,TargetMessageAPI target) {
		this.type = type;
		this.message = message;
		this.code = code;
		this.fieldId = fieldId;
		this.target = target;
				
	}
	
	public MetadataMessage(String join, MetadataMessageType error, TargetMessageAPI toast) {
		
		this.type = error;
		this.target = toast;
		this.message = join;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MetadataMessageType getType() {
		return type;
	}

	public void setType(MetadataMessageType type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public TargetMessageAPI getTarget() {
		if (target==null) {
			return TargetMessageAPI.TOAST;
		}
		return target;
	}

	public void setTarget(TargetMessageAPI target) {
		this.target = target;
	}
}
