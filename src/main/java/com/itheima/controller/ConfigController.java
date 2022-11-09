package com.itheima.controller;
import com.itheima.dao.UserDao;
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

    @PostMapping("/{username}/{password}")
    public R Login1(@PathVariable String username, @PathVariable String password, HttpSession session) {
        List<String> list1 = userDao.getUsername();
        List<String> list2 = userDao.getPassword();
        int flag = 5;
        for (int i = 0; i < list1.size(); i++) {
            if (username.equals(list1.get(i))) {
                if (password.equals(list2.get(i))) {
                    flag = 1;
                    break;
                }
            } else flag = 0;
        }
        if (flag == 1) {
            session.setAttribute("loginUser", username);
            session.setMaxInactiveInterval(5);
            return new R(true, "登录成功");
        } else return new R(false, "您输入的信息有误，请重新输入");
    }
}




