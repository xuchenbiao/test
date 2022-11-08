package com.itheima.controller;
import com.itheima.dao.BookDao;
import com.itheima.dao.BorrowDao;
import com.itheima.domain.Book;
import com.itheima.domain.Borrow;
import com.itheima.service.BookService;
import com.itheima.service.BorrowService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowDao borrowDao;

 @GetMapping("/{id}/{number}")
    public R borrow(@PathVariable Integer id,@PathVariable Integer number){
     if(bookDao.selectNumber(id)>0)//如果图书库里某本图书数量大于0
     {
         List<String> list1=borrowDao.selectName();//列出借书全部名字
         int kk=0;
         Book book=bookService.getById(id);//此处的book是图书库对应id的全部属性
         int k1=book.getNumber();//原本图书数量
         if(k1-number>=0) {
             book.setNumber(k1 - number);
             bookService.updateById(book);
             Borrow borrow = borrowDao.selectAll(book.getName());//借书全部属性
             for (int i = 0; i < list1.size(); i++) {//如果借书有了这个书
                 if (list1.get(i).equals(book.getName())) {
                     kk = 1;
                     break;
                 } else
                     kk = 0;
             }
             if (kk == 1) {
                 return new R(borrowService.update(borrow.getNumber() + number, book.getName()), borrowService.list());
             } else {
                 Borrow borrow1 = new Borrow();
                 borrow1.setName(book.getName());
                 borrow1.setNumber(number);
                 return new R(borrowService.save(borrow1), borrowService.list());
             }
         }
         else
             return new R(false);
     }
     else
         return new R(false);
 }

}
