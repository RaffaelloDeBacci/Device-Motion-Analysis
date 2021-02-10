package com.deepanalysis.devicemotionanalysis.common.data.domain;

import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;

import com.deepanalysis.devicemotionanalysis.common.data.domain.support.AuditableEntity;
import com.deepanalysis.devicemotionanalysis.common.data.domain.support.GpsPoint;
import com.deepanalysis.devicemotionanalysis.common.data.domain.support.ThreeDimensionalData;

@Document(collection="instant_sensors_data")
public class InstantSensorsData extends AuditableEntity {
	
	private String userId;
	private String recordingSessionId;
	
	private ThreeDimensionalData accelletometerData;
	private ThreeDimensionalData gyroscopeData;
	private GpsPoint gpsData;
	private Timestamp timestamp;
	
	public ThreeDimensionalData getAccelletometerData() {
		return accelletometerData;
	}
	
	public void setAccelletometerData(ThreeDimensionalData accelletometerData) {
		this.accelletometerData = accelletometerData;
	}
	
	public ThreeDimensionalData getGyroscopeData() {
		return gyroscopeData;
	}
	
	public void setGyroscopeData(ThreeDimensionalData gyroscopeData) {
		this.gyroscopeData = gyroscopeData;
	}
	
	public GpsPoint getGpsData() {
		return gpsData;
	}
	
	public void setGpsData(GpsPoint gpsData) {
		this.gpsData = gpsData;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecordingSessionId() {
		return recordingSessionId;
	}

	public void setRecordingSessionId(String recordingSessionId) {
		this.recordingSessionId = recordingSessionId;
	}
	
}
