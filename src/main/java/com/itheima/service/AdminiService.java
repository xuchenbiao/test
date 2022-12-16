package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.dao.AdminiDao;
import com.itheima.domain.Admini;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminiService {
    public List<String> getName();
    public List<String> getPassword();
    public IPage<User> getPage(int current, int size);

}
