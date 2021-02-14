package com.deepanalysis.devicemotionanalysis.common.service.impl;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.StopWatch;

import com.deepanalysis.devicemotionanalysis.common.configuration.InjectLogger;
import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;
import com.deepanalysis.devicemotionanalysis.common.data.repository.InstantSensorsDataRepository;
import com.deepanalysis.devicemotionanalysis.common.exception.EntityNotFoundException;
import com.deepanalysis.devicemotionanalysis.common.service.EntityService;

public abstract class AbstractEntityService< E extends AuditableEntity,  R extends MongoRepository<E, String> > implements EntityService<E> {


	protected static final String EMBED_MODIFIED_BY = "modifiedBy";

	protected static final String EMBED_CREATED_BY = "createdBy";

	@Inject
	protected R repository;

	@Inject
	MongoTemplate mongoTemplate;
	
	@Inject
	InstantSensorsDataRepository instantSensorsDataRepository;
	
	// logger

	@InjectLogger
	Logger logger;
	
	
	
	@Override
	public E save(E entity) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Service {} .save start ...", this.getClass().getName());
		}
		
		StopWatch timer = new StopWatch();
		timer.start();
		
		if (logger.isDebugEnabled()) {
			logger.debug("Service {} .save entity converted from mapper. id={}", this.getClass().getName(), entity.getId());
		}
		
		/* TODO per abilitare check in scrittura dobbiamo capire come gestire il caso di salvataggi da scheduler (no user loggato)
		if (!userCanWrite(e, userService.getCurrentLoggedUserId())) {
			throw new EntityNotAllowedException(ACTION.WRITE, getCurrentClass(), e.getId());
		}*/

		entity = repository.save(entity);
		
		entity.setId(entity.getId());
		
		if (logger.isDebugEnabled()) {
			logger.debug("Service {} .save repository saved entity. id={}", this.getClass().getName(), entity.getId());
		}

		timer.stop();
		
		if (logger.isDebugEnabled()) {
			logger.debug("Service {} .save done. ms: {}", this.getClass().getName(), timer.getTotalTimeMillis());
		}
		
		return entity;
	}

	@Override
	public E update(E entity) {
		return this.save(entity);
	}
	
	@Override
	public E getByID(String id) {
		return getEntity(id);
	}
	

	@Override
	public List<E> findByIDs(Collection<String> ids) {
		Query q = new Query(Criteria.where("_id").in(ids));				

		return mongoTemplate.find(q, getCurrentClass());
	}

	@Override
	public boolean delete(String id) {
		E e;
		try {
			e = getEntity(id);			
		} catch (EntityNotFoundException err) {
			logger.warn("Entity not found {}", id);
			return false;
		}	
		
		delete(e);
		return true;
		
	}
	
	@Override
	public void delete(E entity) {
		delete(entity, false);
	}

	public E getEntity(String id) {
		Optional<E> e = repository.findById(id);
		if ( e == null ) {		
			throw new EntityNotFoundException(getCurrentClass(), id);	
		}
		return e.get();
	}

	public E getEntity(E entity) {
		
		if (entity.getId() != null) {
			entity = getEntity(entity.getId());
		} 
		
		return entity;
	}
		
	protected void delete(E entity, boolean force) {
		repository.delete(entity);
	}
	
}
