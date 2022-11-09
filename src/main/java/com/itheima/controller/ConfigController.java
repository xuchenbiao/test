package com.itheima.controller;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            session.setAttribute("loginUser", user.getUsername());
            session.setMaxInactiveInterval(5);
            return new R(true, "登录成功");
        }
        else if ((user.getUsername()==""||user.getPassword()=="")&&flag!=1){
            return new R(false, "请输入完整的信息");
        }
        else if(user.getUsername()!=""&&user.getPassword()!=""&&flag!=1) return new R(false, "您的账号或密码有误，请重新输入");
        else return new R(false,"系统错误");
    }
}





