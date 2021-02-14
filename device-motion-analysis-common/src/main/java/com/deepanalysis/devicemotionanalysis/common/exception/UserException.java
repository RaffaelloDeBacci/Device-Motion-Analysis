package com.deepanalysis.devicemotionanalysis.common.exception;

import org.springframework.context.MessageSourceResolvable;

public class UserException extends RuntimeException implements MessageSourceResolvable{

	ErrorCode code;
	
	Object[] args;
	
	public UserException(ErrorCode code) {
		super(code.name());
		this.code = code;
	}
	
	public UserException(ErrorCode code, Object... args) {
		this(code);
		this.args = args;
	}
	
	public ErrorCode getCode() {
		return code;
	}

	@Override
	public String[] getCodes() {
		return new String[]{"error." + getCode()};
	}

	@Override
	public Object[] getArguments() {
		return this.args;
	}

	@Override
	public String getDefaultMessage() {
		return getCode().name();
	}
}