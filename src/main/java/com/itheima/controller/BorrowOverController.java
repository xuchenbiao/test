package com.itheima.controller;

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
    @GetMapping
    public R getAll(){
        return new R(true,borrowService.list());
    }
    @GetMapping("/name/{name}")
    public R getByName(@PathVariable String name){
        return new R(true,borrowService.getByName(name));
    }
}
