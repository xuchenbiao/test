package com.itheima.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminiDao {
    @Select("select admininame from admini")
    public List<String> getName();
    @Select("select adminipassword from admini")
    public List<String> getPassword();
}
