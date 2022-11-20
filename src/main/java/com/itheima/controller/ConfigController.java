package com.itheima.controller;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.JwtUtil;
import com.itheima.util.R;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
@RequestMapping("/logins")
public class ConfigController {
    @Autowired
    private UserDao userDao;


    @PostMapping
    public R Login1(@RequestBody User user, HttpSession session) {
        List<String> list1 = userDao.getUsername();
       List<String> list2 = userDao.getPassword();
        int flag = 5;


       for (int i = 0; i < list1.size(); i++) {
           if (user.getUsername().equals(list1.get(i))) {
               if (user.getPassword().equals(list2.get(i))) {
                   flag = 1;
                   break;
               }
           } else flag = 0;
       }
       if (flag == 1&&(user.getUsername()!=""&&user.getPassword()!="")) {
           Object obj=session.getAttribute("loginUser");
           if(obj==null){
               session.setAttribute("loginUser","admini");
               session.setMaxInactiveInterval(20);}
           String token= JwtUtil.createJwt(user.getUsername());
           user.setToken(token);
           return new R(true,user, "登录成功");
       }
       else if ((user.getUsername()==""||user.getPassword()=="")&&flag!=1){
           return new R(false, "请输入完整的信息");
       }
       else if(user.getUsername()!=""&&user.getPassword()!=""&&flag!=1) return new R(false, "您的账号或密码有误，请重新输入");
        else return new R(false,"系统错误");
    }

    @GetMapping
    public R checkToken(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("token");
        return new R(JwtUtil.checkToken(token));
    }

}





