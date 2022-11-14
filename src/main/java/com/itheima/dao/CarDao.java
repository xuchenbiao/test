package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CarDao extends BaseMapper<Car> {
    @Select("select name from car ")
    public List<String> getAllName();
    @Update("update car set number=#{number},price=#{price},totalprice=#{totalprice} where name =#{name}")
    public void update(Integer number,double price,double totalprice,String name);
    @Select("select number from car where name=#{name}")
    public Integer getNumber(String name);

}
