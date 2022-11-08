package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BorrowDao;
import com.itheima.domain.Borrow;
import com.itheima.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowDao, Borrow> implements BorrowService {
    @Autowired
    private BorrowDao borrowDao;
    @Override
    public boolean update(Integer number, String name) {
       borrowDao.update(number,name);
     return true;
    }

    @Override
    public List<Borrow> getByName(String name) {
        return borrowDao.getByName(name);
    }
}
