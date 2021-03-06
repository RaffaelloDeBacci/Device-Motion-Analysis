package com.deepanalysis.devicemotionanalysis.common.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EntityService< E > {   
    
		E getByID(String id);
		
		List<E> findByIDs(Collection<String> ids);
	    
		E save(E objectToSave);
		
		E update(E objectToSave);
		
		boolean delete(String id);

		void delete(E entity);
		
		Class<E> getCurrentClass();
		
}
