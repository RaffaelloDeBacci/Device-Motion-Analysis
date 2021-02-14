package com.deepanalysis.devicemotionanalysis.common.rest.model;

import java.lang.reflect.ParameterizedType;

public class Response<P, M extends Metadata>{

	private P payload;
	
	private M metadata;

	public P getPayload() {
		return payload;
	}

	public void setPayload(P payload) {
		this.payload = payload;
	}
	
	public M getMetadata() {
		if (metadata == null){
			try {
				metadata = ((Class<M>) (((ParameterizedType) getClass().getGenericSuperclass())
						.getActualTypeArguments()[1])).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				
			}	
		}
		return metadata;
	}
	
	public void setMetadata(M metadata) {
		this.metadata = metadata;
	}
}
	