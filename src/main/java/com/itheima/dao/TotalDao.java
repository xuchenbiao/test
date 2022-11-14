package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Total;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TotalDao extends BaseMapper<Total> {
    @Update("update total set number=#{number},price=#{price},totalprice=#{totalprice} where name =#{name}")
    public void update(Integer number,double price,double totalprice,String name);
    @Select("select number from total where name=#{name}")
    public Integer getNumber(String name);
   @Delete("delete from car")
    public void deleteAll();
}
