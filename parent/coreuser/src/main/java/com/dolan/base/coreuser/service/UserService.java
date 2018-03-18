package com.dolan.base.coreuser.service;

import com.dolan.base.coreuser.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangqj
 * @desc
 * @since 3/5/18 12:07 AM
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum,int pageSize);

}
