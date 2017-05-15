package com.dolan.springmvc.service;

import java.util.List;

import com.dolan.springmvc.model.UserProfile;

public interface UserProfileService {
	UserProfile findById(int id);
	UserProfile findByType(String type);
	List<UserProfile> findAll();
}
