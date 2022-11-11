package com.itheima.service;

import com.itheima.dao.AdminiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminiService {
    public List<String> getName();
    public List<String> getPassword();

}
