package com.deepanalysis.devicemotionanalysis.common.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deepanalysis.devicemotionanalysis.common.data.domain.InstantSensorsData;

public interface InstantSensorsDataRepository extends MongoRepository<InstantSensorsData, String>  {
	public InstantSensorsData findBy_id(String id);
}
 