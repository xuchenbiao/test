package com.itheima.controller;
import com.itheima.dao.BookDao;
import com.itheima.dao.BorrowDao;
import com.itheima.domain.Book;
import com.itheima.domain.Borrow;
import com.itheima.service.BookService;
import com.itheima.service.BorrowService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/returns")
public class ReturnController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowDao borrowDao;
    @GetMapping("/{id}/{number}")
    public R retu(@PathVariable Integer id,@PathVariable Integer number) {
        int z = 0;
        List<Integer> list = borrowDao.selectAllId();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i))) {
                z = 1;
                break;
            } else
                z = 0;
        }
        if (z == 0) {
            return new R(false);
        } else {
                String name = borrowDao.selectName1(id);
                Book book = bookDao.selectAll(name);

                Borrow borrow = borrowDao.selectAll(book.getName());//借书全部属性
                int k2 = borrowDao.selectNumber(id);
                borrow.setNumber(k2 - number);

                if (borrow.getNumber()>0){
                    book.setNumber(book.getNumber() + number);
                    bookService.updateById(book);//更新原本图书数量
                return new R(borrowService.updateById(borrow), borrowService.list());}
                else if(borrow.getNumber()==0){
                    book.setNumber(book.getNumber() + number);
                    bookService.updateById(book);//更新原本图书数量
                    return new R(borrowService.removeById(id),borrowService.list());}
                else  return new R(false);
        }
    }

    @GetMapping("{id}")
    public R returnAll(@PathVariable Integer id){
        int z = 0;
        List<Integer> list = borrowDao.selectAllId();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i))) {
                z = 1;
                break;
            } else
                z = 0;
        }
        if (z == 0) {
            return new R(false);
        } else{
            String name = borrowDao.selectName1(id);//此id对应的名字
            Book book = bookDao.selectAll(name);//通过名字找到主页图书全部属性
            int k2 = borrowDao.selectNumber(id);
           book.setNumber(book.getNumber()+k2);
           bookService.updateById(book);
           return new R(borrowService.removeById(id));

        }



    }


}
