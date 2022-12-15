package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Borrow;
import com.itheima.service.BorrowService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowOver")
public class BorrowOverController {
    @Autowired
    private BorrowService borrowService;
    @GetMapping("{current}/{size}")
    public R getAll(@PathVariable int current,@PathVariable int size){
        IPage<Borrow> page = borrowService.getPage(current, size);
        if (current>page.getPages()){
            page=borrowService.getPage((int)page.getPages(),size);
        }

        return new R(true,page);
    }
    @GetMapping("/name/{name}")
    public R getByName(@PathVariable String name){
        return new R(true,borrowService.getByName(name));
    }
}
