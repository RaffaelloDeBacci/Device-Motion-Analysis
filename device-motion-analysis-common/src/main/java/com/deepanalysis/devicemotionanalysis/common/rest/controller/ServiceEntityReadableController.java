package com.deepanalysis.devicemotionanalysis.common.rest.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepanalysis.devicemotionanalysis.common.configuration.InjectLogger;
import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;
import com.deepanalysis.devicemotionanalysis.common.rest.model.BaseResponse;
import com.deepanalysis.devicemotionanalysis.common.service.EntityService;

public abstract class ServiceEntityReadableController<E extends AuditableEntity, S extends EntityService< E>>
		extends BaseController {

	@Inject
	protected S service;

	@Inject
	MongoTemplate mongoTemplate;

	@InjectLogger
	protected Logger logger;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<BaseResponse<E>> getByPK(@PathVariable String id,

			@RequestParam(required = false) String embed, @RequestParam(required = false) String computedFields) {

		if (logger.isDebugEnabled())
			logger.debug("Service {}   entity getByPK {}", this.getClass().getName(), id);

		E entity = service.getByID(id);

		return ok(entity);
	}

}
