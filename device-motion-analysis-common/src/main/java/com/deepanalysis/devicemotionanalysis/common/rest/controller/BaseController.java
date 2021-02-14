package com.deepanalysis.devicemotionanalysis.common.rest.controller;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

import com.deepanalysis.devicemotionanalysis.common.configuration.InjectLogger;
import com.deepanalysis.devicemotionanalysis.common.rest.model.BaseResponse;
import com.deepanalysis.devicemotionanalysis.common.rest.model.Metadata;
import com.deepanalysis.devicemotionanalysis.common.service.UserService;

public class BaseController {

	@Inject
	UserService userService;
	
	@InjectLogger
	protected Logger logger;

	
	protected <T> ResponseEntity<BaseResponse<T>> ok(T payload) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setPayload(payload);
		return ResponseEntity.ok(response);
	}
	
	protected <T> ResponseEntity<BaseResponse<T>> ok(T payload, HttpStatus status) {	
		BaseResponse<T> response = new BaseResponse<>();
		response.setPayload(payload);
		BodyBuilder bodyResponse = ResponseEntity.status(status);
		return bodyResponse.body(response);
	}
	
	protected <T> ResponseEntity<BaseResponse<T>> ok(T payload, Metadata metadata ) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setMetadata(metadata);
		response.setPayload(payload);
		return ResponseEntity.ok(response);
	}


	protected <T> ResponseEntity<BaseResponse<T>> ok(T payload, Metadata metadata, HttpStatus status ) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setMetadata(metadata);
		response.setPayload(payload);
		BodyBuilder bodyResponse = ResponseEntity.status(status);
		return bodyResponse.body(response);
	}
	
	protected void setCacheControl(long maxAge, TimeUnit timeUnit, HttpServletResponse httpResponse) {
		CacheControl cacheControl = CacheControl.maxAge(maxAge, timeUnit)
				.noTransform()
				.mustRevalidate();
		
		httpResponse.setHeader(HttpHeaders.CACHE_CONTROL, cacheControl.getHeaderValue());
	}

	
}
