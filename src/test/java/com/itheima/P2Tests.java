package com.itheima;

import com.itheima.dao.AdminiDao;
import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class P2Tests {
    @Autowired
    private AdminiDao adminiDao;
    @Autowired
    private UserService userService;
    @Test
    public void g1(){
        adminiDao.getName();
        adminiDao.getPassword();
    }
    @Test
    public void g2(){
        userService.getUserNames("x");
    }
}
