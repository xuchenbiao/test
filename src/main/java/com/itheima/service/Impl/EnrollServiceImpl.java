package com.itheima.service.Impl;

import com.itheima.dao.EnrollDao;
import com.itheima.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollServiceImpl implements EnrollService {
    @Autowired
    private EnrollDao enrollDao;
    @Override
    public boolean insert(String username,String password) {
        enrollDao.insert(username,password);
        return true;
    }
}
