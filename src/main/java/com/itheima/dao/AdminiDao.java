package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Admini;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminiDao extends BaseMapper<Admini> {
    @Select("select admininame from admini")
    public List<String> getName();
    @Select("select adminipassword from admini")
    public List<String> getPassword();
}
