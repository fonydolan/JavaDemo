package com.dolan.base.web;

import com.dolan.base.coreuser.mapper.UserMapper;
import com.dolan.base.coreuser.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){

        User user = new User();
        user.setUserName("winterchen");
        user.setPassword("123456");
        user.setPhone("12345678910");

        userMapper.insert(user);
        User u = userMapper.findUserByPhone("12345678910");
        Assert.assertEquals("winterchen", u.getUserName());
    }

}
