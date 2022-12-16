package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.AdminiDao;
import com.itheima.domain.Admini;
import com.itheima.domain.User;
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

    @Override
    public IPage<User> getPage(int current, int size) {
        IPage page=new Page(current,size);
        adminiDao.selectPage(page,null);
        return page;
    }
}
