package com.hyf.dao;

import com.hyf.entity.User;

import java.util.Set;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public interface UserDao {
    User login(User user);

    boolean isLogin(User user);

    boolean isRegist(User user);

    void registe(User user);

    Set<String> getRoles(String userName);

    User getByUserName(String userName);

    Set<String> getPermissions(String userName);
}
