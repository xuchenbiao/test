package com.itheima.controller;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConfigController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session) {
        List<String> list1 = userDao.getUsername();
        List<String> list2 = userDao.getPassword();
        int flag=5;
        for (int i = 0; i < list1.size(); i++) {

            if (username.equals(list1.get(i))) {
                if (password.equals(list2.get(i))){
                    flag=1;
                    break;
                }
            }
            else flag=0;

        }
        if (flag==0||username==""){
            return "redirect:index.html";
        }
        // else return "/pages/books";
        else{
            session.setAttribute("loginUser",username);
            session.setMaxInactiveInterval(5);
            return "redirect:/pages/books.html";}
    }
}
