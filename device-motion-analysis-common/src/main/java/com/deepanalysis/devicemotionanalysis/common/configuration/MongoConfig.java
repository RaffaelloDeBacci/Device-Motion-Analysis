/*package com.deepanalysis.devicemotionanalysis.common.configuration;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.deepanalysis.devicemotionanalysis.common.data.changelogs.DummyChangelog;
import com.deepanalysis.devicemotionanalysis.common.data.domain.User;
import com.deepanalysis.devicemotionanalysis.common.data.repository.UserRepository;
import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@EnableMongoAuditing
@EntityScan(basePackageClasses = User.class)
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoConfig {
	
	@InjectLogger
	Logger logger;

    @Value("${spring.data.mongodb.checkcertificate:false}")
    private Boolean checkcertificate;
    
    @Value("${mongock.enabled}")
    private boolean mongockEnabled;
	
	@Bean
    public MongoClientOptions mongoClientOptions(){
		
		 MongoClientOptions.Builder builder = MongoClientOptions.builder();
		 
		if(checkcertificate)
		{
			logger.info("mongo use SSL with certificate  in /tmp/*****.jks");
			
//	        System.setProperty ("javax.net.ssl.keyStore","/tmp/*****.jks");
//	        System.setProperty ("javax.net.ssl.keyStorePassword","***********");
//	        System.setProperty ("javax.net.ssl.trustStore","/tmp/*****.jks");
//		    System.setProperty ("javax.net.ssl.trustStorePassword","*******"); 
//		    
//	        builder.sslInvalidHostNameAllowed(true); //TEMP
	        builder=builder.sslEnabled(true);
		}
		return builder.build();     
    }
	
	@Bean
	@ConditionalOnProperty(name = "mongock.enabled", havingValue = "true")
	public SpringBootMongock mongock(MongoClient mongoClient, MongoTemplate mongoTemplate, ApplicationContext applicationContext) {
	  logger.debug("Mongock enabled: {}", mongockEnabled);
	  return new SpringBootMongockBuilder(mongoClient, mongoTemplate.getDb().getName(), DummyChangelog.class.getPackage().getName())
		  .setApplicationContext(applicationContext)
		  .setEnabled(mongockEnabled)
	      .setLockQuickConfig()
	      .build();
	}

}*/
