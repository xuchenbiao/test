package com.itheima.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookService extends IService<Book>  {
  public List<Book> getByName(String name);
    public List<Book> getByName2();
    public List<Book> getByType(String type);
    public List<Book> getByType2();


}
