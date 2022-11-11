package com.itheima.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select username from user ")
    public List<String> getUsername();
    @Select("select password from user ")
    public List<String> getPassword();
    @Select("select username from user where username like CONCAT('%', #{username}, '%')")
    public List<String> getUserNames(String username);
}
