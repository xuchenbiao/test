package com.itheima.service.Impl;

import com.itheima.dao.AdminiDao;
import com.itheima.service.AdminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminiServiceImpl implements AdminiService {
    @Autowired
    private AdminiDao adminiDao;
    @Override
    public List<String> getName() {
        return adminiDao.getName();
    }

    @Override
    public List<String> getPassword() {
        return adminiDao.getPassword();
    }
}
