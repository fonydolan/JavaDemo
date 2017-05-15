package com.dolan.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolan.springmvc.dao.UserProfileDao;
import com.dolan.springmvc.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao dao;
    
	@Override
	public UserProfile findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public UserProfile findByType(String type) {
		// TODO Auto-generated method stub
		return dao.findByType(type);
	}

	@Override
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
