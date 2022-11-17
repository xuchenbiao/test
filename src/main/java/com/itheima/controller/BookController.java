

package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }
    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }





   @GetMapping("/name/{name}")
    public R getByName(@PathVariable String name){


        return new R(true,bookService.getByName(name));

   }
    @GetMapping("/name/")
    public R getByName(){
        return new R(true,bookService.getByName2());
    }
    @GetMapping("/type/{type}")
    public R getByType(@PathVariable String type){


        return new R(true,bookService.getByType(type));

    }
    @GetMapping("/type/")
    public R getByType(){
        return new R(true,bookService.getByType2());
    }

    @GetMapping("/nade/{nade}")
    public R getByNameAndDescription(@PathVariable String nade){
        List<Book> list1=bookService.getByName(nade);
        List<Book> list2=bookService.getByDescription(nade);
        for (int i=0;i<list2.size();i++){
            int k=0;
           for (int j=0;j<list1.size();j++){
              k=0;
               if (list1.get(j).getId().equals(list2.get(i).getId()))
               { k=1;
               break;}
           }
        if (k==0){
            list1.add(list2.get(i));
        }
        }
        return new R(true,list1);
    }

}
