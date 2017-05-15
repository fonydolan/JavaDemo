package com.dolan.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolan.springmvc.dao.UserDao;
import com.dolan.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return dao.findBySSO(sso);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		dao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setPassword(user.getPassword());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		dao.deleteBySSO(sso);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		// TODO Auto-generated method stub
		 User user = findBySSO(sso);
         return ( user == null || ((id != null) && (user.getId() == id)));
	}

}
