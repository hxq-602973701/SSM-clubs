package com.hyf.service.impl;

import com.hyf.dao.UserDao;
import com.hyf.entity.User;
import com.hyf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
