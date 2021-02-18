package com.deepanalysis.devicemotionanalysis.api.controller;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepanalysis.devicemotionanalysis.common.rest.controller.BaseController;
import com.deepanalysis.devicemotionanalysis.common.service.InstantSensorsDataService;

@RestController
@RequestMapping(value = "/api/instant-sensors-data")
public class InstantSensorsDataController extends BaseController {
	
	@Inject
	InstantSensorsDataService instantSensorsDataService;
	

	@Inject
	MongoTemplate mongoTemplate;

}
