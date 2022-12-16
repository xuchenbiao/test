package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
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

    @Override
    public List<String> getUserNames(String username) {
        return userDao.getUserNames(username);
    }

    @Override
    public List<User> getName(String username) {
        return userDao.getName(username);
    }

    @Override
    public IPage<User> getPage(int current, int size) {
        IPage page=new Page(current,size);
        userDao.selectPage(page,null);
        return page;
    }
}
