package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Total;

public interface TotalService extends IService<Total> {
    public boolean update(Integer number,double price,double totalprice,String name);
    public Integer  getNumber(String name);
}
