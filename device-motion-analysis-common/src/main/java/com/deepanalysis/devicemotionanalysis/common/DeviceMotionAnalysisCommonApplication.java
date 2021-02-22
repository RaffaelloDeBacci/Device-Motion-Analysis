package com.deepanalysis.devicemotionanalysis.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com")
public class DeviceMotionAnalysisCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceMotionAnalysisCommonApplication.class, args);
	}

}
