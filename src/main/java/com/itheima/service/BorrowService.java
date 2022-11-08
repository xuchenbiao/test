package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BorrowDao;
import com.itheima.domain.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BorrowService extends IService<Borrow> {
    public boolean update(Integer number,String name);
    public List<Borrow> getByName(String name);
}
