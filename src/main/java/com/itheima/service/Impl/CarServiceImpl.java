package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.CarDao;
import com.itheima.domain.Car;
import com.itheima.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {
    @Autowired
    private CarDao carDao;
    @Override
    public List<String> getAllName() {
        return carDao.getAllName();
    }

    @Override
    public boolean update(Integer number, double price, double totalprice,String name ) {
        carDao.update(number,price,totalprice,name);
        return true;
    }

    @Override
    public Integer getNumber(String name) {
        return carDao.getNumber(name);
    }
}
