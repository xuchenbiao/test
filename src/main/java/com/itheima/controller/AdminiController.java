package com.itheima.controller;
import com.itheima.domain.EJ;
import com.itheima.service.UserService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminiplus")
public class AdminiController {
    @Autowired
    private UserService userService;
    @GetMapping("/admininame")
    public R getName(){
        return new R(true,userService.getName());
    }
    @GetMapping("/name/{name}")
    public R getNameByName(@PathVariable String name){
        return new R(true,userService.getUserNames(name),null);
    }
    @PostMapping
    public R getPassword(@RequestBody EJ ej){
        if(ej.getPassword().equals("123456")){
            return new R(true,userService.getPassword());
        }
        else
            return new R(false,"密码错误");
    }

}
