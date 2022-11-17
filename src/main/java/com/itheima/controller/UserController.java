package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.util.R;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
   @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(userService.removeById(id));
    }
    @PutMapping
    public R put(@RequestBody User user){
       return new R(userService.updateById(user));
    }
    @GetMapping("/name/{name}")
    public R getName(@PathVariable String name){
       return new R(true,userService.getName(name),null);
    }
}
