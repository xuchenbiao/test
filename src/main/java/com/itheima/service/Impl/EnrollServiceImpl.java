package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.EnrollDao;
import com.itheima.domain.User;
import com.itheima.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollServiceImpl extends ServiceImpl<EnrollDao, User> implements EnrollService {

}
