package com.dolan.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dolan.springmvc.model.UserProfile;
import com.dolan.springmvc.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

	@Autowired
	UserProfileService userProfileService;
	
	@Override
	public UserProfile convert(Object ele) {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt((String)ele);
		UserProfile profile = userProfileService.findById(id);
		System.out.println("Profile:"+profile);
		return profile;
	}

}
