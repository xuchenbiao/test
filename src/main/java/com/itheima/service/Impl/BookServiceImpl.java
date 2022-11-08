package com.itheima.service.Impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getByName(String name) {

       return bookDao.selectByName(name);
    }

    @Override
    public List<Book> getByName2() {
        return bookDao.selectByName2();
    }

    @Override
    public List<Book> getByType(String type) {
        return bookDao.selectByType(type);
    }

    @Override
    public List<Book> getByType2() {
        return bookDao.selectByType2();
    }






}
