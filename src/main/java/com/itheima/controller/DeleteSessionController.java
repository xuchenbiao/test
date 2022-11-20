package com.itheima.controller;

import com.itheima.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/deleteSession")
public class DeleteSessionController {
    @GetMapping
    public R deleteSession(HttpSession session){
        session.setAttribute("delete1","d");
//        Object obj=session.getAttribute("delete1");
//        System.out.println("66"+obj);
        System.out.println("eeeee");
        return  new R(true);
    }
}
