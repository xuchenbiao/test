package com.itheima.service.Impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<String> getName() {
        return userDao.getUsername();
    }

    @Override
    public List<String> getPassword() {
        return userDao.getPassword();
    }
}
