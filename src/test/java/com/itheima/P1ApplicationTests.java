package com.itheima;

import com.itheima.dao.BookDao;

import com.itheima.dao.BorrowDao;
import com.itheima.domain.Book;
import com.itheima.domain.Borrow;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Transactional
class P1ApplicationTests {

@Autowired
private BookService bookService;
    @Autowired
    BookDao bookDao;
@Autowired
    BorrowDao borrowDao;
    @Test
    public void getByName(){
        System.out.println(bookService.getByName("b"));
    }


    @Test
    public void get(){
        Borrow borrow=new Borrow();
      borrow.setName("遮天");
      borrow.setNumber(55);
        System.out.println(borrowDao.insert(borrow));
    }
    @Test
    public void get1(){
        System.out.println(bookDao.selectNumber(1));
    }
    @Test
    public void get2(){
        borrowDao.update(77,"斗破苍穹");
    }
    @Test
    public void get3(){
       borrowDao.selectAll("斗破苍穹");
    }
    @Test
    public void get4(){
        borrowDao.selectNumber(12);
    }
    @Test
    public void get5(){
        borrowDao.getByName("斗");
    }
    @Test
    public  void  get6(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder bulider= MockMvcRequestBuilders.get("/books/1");
        mockMvc.perform(bulider);
    }
    @Test
    public void get7(){
        Book book=new Book();
        book.setNumber(52);
        book.setType("一一一");
        book.setName("牛牛");
        bookService.save(book);
    }
}
