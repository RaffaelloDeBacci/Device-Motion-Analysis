package com.deepanalysis.devicemotionanalysis.common.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deepanalysis.devicemotionanalysis.common.data.domain.User;

public interface UserRepository extends MongoRepository<User, String>  {
	public User findBy_id(String id);
}
 