package com.hyf.service.impl;

import com.hyf.dao.UserDao;
import com.hyf.entity.User;
import com.hyf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

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

    @Override
    public boolean isLogin(User user) {
        return userDao.isLogin(user);
    }

    @Override
    public boolean isRegist(User user) {
        return userDao.isRegist(user);
    }

    @Override
    public void registe(User user) {
        userDao.registe(user);
    }

    @Override
    public Set<String> getRoles(String userName) {
        return userDao.getRoles(userName);
    }

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    @Override
    public Set<String> getPermissions(String userName) {
        return userDao.getPermissions(userName);
    }
}
