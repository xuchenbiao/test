package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Car;

import java.util.List;

public interface CarService extends IService<Car> {
    public List<String> getAllName();
    public boolean update(Integer number,double price,double totalprice,String name);
    public Integer  getNumber(String name);
}
