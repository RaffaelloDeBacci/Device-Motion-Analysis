package com.deepanalysis.devicemotionanalysis.common.exception;

import org.apache.commons.lang3.StringUtils;

import jdk.jshell.spi.ExecutionControl.UserException;

public class BaseEntityException extends UserException{

	private Class<?> entityClass;
	private Object pk;

	public <T> BaseEntityException(ErrorCode code, Class<T> entityClass, Object pk) {
		super(code, StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(entityClass.getSimpleName()), StringUtils.SPACE), pk);
		this.pk = pk;
		this.entityClass = entityClass;
	}
	
	public Class<?> getEntityClass() {
		return entityClass;
	}
	
	public Object getPk() {
		return pk;
	}
}
