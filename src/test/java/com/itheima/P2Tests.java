package com.itheima;

import com.itheima.dao.AdminiDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class P2Tests {
    @Autowired
    private AdminiDao adminiDao;
    @Test
    public void g1(){
        adminiDao.getName();
        adminiDao.getPassword();
    }
}
