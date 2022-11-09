package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnrollDao {
    @Select("select username from user")
    public List<String> getAllName();
    @Insert("insert into user(username,password) values (#{username},#{password})")
    public void insert(String username,String password);
}
