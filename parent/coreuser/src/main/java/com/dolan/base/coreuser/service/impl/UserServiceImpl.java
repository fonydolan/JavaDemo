package com.dolan.base.coreuser.service.impl;

import com.dolan.base.coreuser.mapper.UserMapper;
import com.dolan.base.coreuser.model.User;
import com.dolan.base.coreuser.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangqj
 * @desc
 * @since 3/5/18 12:10 AM
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired UserMapper userMapper;

    @Override public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
    /*
      * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
      * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
      * pageNum 开始页数
      * pageSize 每页显示的数据条数
      * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
