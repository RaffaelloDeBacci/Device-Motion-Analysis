package com.deepanalysis.devicemotionanalysis.common.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;
import com.deepanalysis.devicemotionanalysis.common.rest.model.BaseResponse;
import com.deepanalysis.devicemotionanalysis.common.service.EntityService;

public abstract class ServiceEntityWritableController<E extends AuditableEntity, S extends EntityService<E>>
		extends ServiceEntityReadableController<E, S> {


	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse<E>> create(@RequestBody(required = true) E objectToSave) {
		if (logger.isDebugEnabled()) {
			logger.debug("Service {}  create entity ", this.getClass().getName());
		}

		BaseResponse<E> response = new BaseResponse<>();
		E dto = service.save(objectToSave);
		response.setPayload(dto);

		if (logger.isDebugEnabled()) {
			logger.debug("Service {}   entity created ", this.getClass().getName());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse<E>> update(@RequestBody E bo, @PathVariable String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Service {}  update entity ", this.getClass().getName());
		}
		E dto = null;
		if (id.equals(bo.getId())) {
			dto = service.update(bo);
			if (logger.isDebugEnabled()) {
				logger.debug("Service {}   entity updated ", this.getClass().getName());
			}
		} else {
			logger.warn("Service {}  update entity , id {} not found or doesn match with object",
					this.getClass().getName(), id);
		}
		return ok(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse<Boolean>> delete(@PathVariable String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Service {}  delete entity {}", this.getClass().getName(), id);
		}
		boolean deleted = service.delete(id);
		if (logger.isDebugEnabled()) {
			logger.debug("Service {}   entity deleted {} => {}", this.getClass().getName(), id, deleted);
		}
		return ok(deleted);
	}

}
