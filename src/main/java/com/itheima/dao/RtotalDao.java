package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Rtotal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RtotalDao extends BaseMapper<Rtotal> {
    @Select("select * from rtotal where name=#{name}")
    public List<Rtotal> selectByName(String name);
    @Delete("delete from rtotal")
    public boolean deleteAllRtotal();
}
