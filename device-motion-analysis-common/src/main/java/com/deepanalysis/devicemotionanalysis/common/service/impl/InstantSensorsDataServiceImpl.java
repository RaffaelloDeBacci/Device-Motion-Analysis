package com.deepanalysis.devicemotionanalysis.common.service.impl;

import org.springframework.stereotype.Service;

import com.deepanalysis.devicemotionanalysis.common.data.domain.InstantSensorsData;
import com.deepanalysis.devicemotionanalysis.common.data.repository.InstantSensorsDataRepository;
import com.deepanalysis.devicemotionanalysis.common.service.InstantSensorsDataService;

@Service
public class InstantSensorsDataServiceImpl extends AbstractEntityService<InstantSensorsData, InstantSensorsDataRepository> implements InstantSensorsDataService {

	@Override
	public Class getCurrentClass() {
		return InstantSensorsData.class;
	}

}
