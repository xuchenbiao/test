package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Borrow;
import com.itheima.domain.Total;

public interface TotalService extends IService<Total> {
    public boolean update(Integer number,double price,double totalprice,String name);
    public Integer  getNumber(String name);
    public boolean deleteAll();
    public boolean deleteAllTotal();
    public IPage<Total> getPage(int current, int size);
}

//java,c++,python
