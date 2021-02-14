package com.deepanalysis.devicemotionanalysis.common.service.impl;

import org.springframework.stereotype.Service;

import com.deepanalysis.devicemotionanalysis.common.data.domain.User;
import com.deepanalysis.devicemotionanalysis.common.data.repository.UserRepository;
import com.deepanalysis.devicemotionanalysis.common.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityService<User, UserRepository> implements UserService {

	@Override
	public Class getCurrentClass() {
		return User.class;
	}

}
