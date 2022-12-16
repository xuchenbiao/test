package com.itheima.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Admini;
import com.itheima.domain.EJ;
import com.itheima.domain.User;
import com.itheima.service.AdminiService;
import com.itheima.service.UserService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminiplus")
public class AdminiController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminiService adminiService;
    @GetMapping("/admininame")
    public R getName(){
        return new R(true,userService.getName());
    }
    @GetMapping("/admini/{current}/{size}")
    public R getAll(@PathVariable int current,@PathVariable int size){
        IPage<User> page = adminiService.getPage(current, size);
        if (current>page.getPages())
            page=adminiService.getPage((int)page.getPages(),size);
        return new R(true,page);
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
