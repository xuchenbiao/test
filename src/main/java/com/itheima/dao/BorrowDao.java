package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowDao extends BaseMapper<Borrow> {
    @Select("select name from borrow ")
    public List<String> selectName();
    @Update("update borrow set number=#{number} where name =#{name}")
    public void update(Integer number,String name);
    @Select("select * from borrow where name=#{name}")
    public Borrow selectAll(String name);
    @Delete("select * from borrow where name=#{name}")
    public void delete(String name);
    @Select("select number from borrow where id=#{id}")
    public int selectNumber(Integer id);
    @Select("select name from borrow where id=#{id}")
    public String selectName1(Integer id);
    @Select("select id from borrow")
    public List<Integer> selectAllId();
    @Select("select * from borrow where name like concat('%',#{name},'%')")//通过名字查全部
    public List<Borrow> getByName(String name);

}
