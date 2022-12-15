package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.AdminiDao;
import com.itheima.dao.BookDao;
import com.itheima.dao.TotalDao;
import com.itheima.domain.Book;
import com.itheima.domain.Car;
import com.itheima.service.BookService;
import com.itheima.service.CarService;

import com.itheima.service.RtotalService;
import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class P2Tests {
    @Autowired
    private AdminiDao adminiDao;
    @Autowired
    private UserService userService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CarService carService;
    @Autowired
    private TotalDao totalDao;
    @Autowired
    private BookService bookService;
   @Autowired
   private RtotalService rtotalService;
    @Test
    public void g1(){
        adminiDao.getName();
        adminiDao.getPassword();
    }
    @Test
    public void g2(){
        userService.getUserNames("x");
    }
//    @Test
//    public void g3(){
//        bookDao.selectTotalPrice(1);
//    }
    @Test
    public void g3(){
        Car car=new Car();
        car.setName("无敌剑域");
        car.setNumber(22);
        car.setPrice(56.3);
        carService.save(car);
    }
    @Test
    public void g4(){
       carService.getAllName();
    }

    @Test
    public void g5(){
        bookService.getByDescription("好");
    }
    @Test
    public void g6(){
      rtotalService.list();

    }
    @Test
    public void g7(){
       IPage page=new Page(1,1);
       bookService.page(page,null);
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }
    @Test
    public void f(){
        rtotalService.selectByName("一剑独尊");
    }
}
