package com.itheima.dao;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    @Select("select * from book where name like CONCAT('%', #{name}, '%')")
    public List<Book> selectByName(String name);
    @Select("select * from book ")
    public List<Book> selectByName2();
    @Select("select * from book where type like CONCAT('%', #{type}, '%')")
    public List<Book> selectByType(String type);
    @Select("select * from book ")
    public List<Book> selectByType2();
    @Select("select number from book where id=#{id}")//放回原本图书数量
    public int selectNumber(Integer id);
    @Select("select * from book where name=#{name}")//放回原本图书数量
    public Book selectAll(String name);
    @Select("select price from book where id=#{id}")//单价
    public double selectPrice(Integer id);
    @Select("select totalPrice from book where id=#{id}")//总价
    public double selectTotalPrice(Integer id);
    @Update("update book set number=#{number} where name =#{name}")
    public void update(Integer number,String name);
    @Select("select number from book where name=#{name}")
    public Integer getNumberByName(String name);
}
