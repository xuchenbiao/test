package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.TotalDao;
import com.itheima.domain.Total;
import com.itheima.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalServiceImpl extends ServiceImpl<TotalDao, Total> implements TotalService {
    @Autowired
    private TotalDao totalDao;
    @Override
    public boolean update(Integer number, double price, double totalprice,String name ) {
        totalDao.update(number,price,totalprice,name);
        return true;
    }
    @Override
    public Integer getNumber(String name) {
        return totalDao.getNumber(name);
    }

    @Override
    public boolean deleteAll() {
         totalDao.deleteAll();
         return true;
    }

    @Override
    public boolean deleteAllTotal() {
        return totalDao.deleteAllTotal();
    }

    @Override
    public IPage<Total> getPage(int current, int size) {
        IPage page=new Page(current,size);
        totalDao.selectPage(page,null);
        return page;

    }
}
