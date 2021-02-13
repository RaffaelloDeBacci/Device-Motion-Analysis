package com.deepanalysis.devicemotionanalysis.common.exception;

public class EntityNotFoundException extends BaseEntityException{

	public <T> EntityNotFoundException(Class<T> entityClass, Object pk) {
		super(ErrorCode.RESOURCE_NOT_FOUND, entityClass, pk);
	}

}
