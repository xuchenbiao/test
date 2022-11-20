package com.itheima.controller;

import com.itheima.domain.Admini;
import com.itheima.service.AdminiService;
import com.itheima.util.JwtUtil;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/adminis")
public class AdminiConfigController {
   @Autowired
   private AdminiService adminiService;
    @PostMapping
    public R Login1(@RequestBody Admini admini, HttpSession session) {
        List<String> list1 =adminiService.getName();
        List<String> list2 =adminiService.getPassword();
        int flag = 5;


        for (int i = 0; i < list1.size(); i++) {
            if (admini.getAdmininame().equals(list1.get(i))) {
                if (admini.getAdminipassword().equals(list2.get(i))) {
                    flag = 1;
                    break;
                }
            } else flag = 0;
        }
        if (flag == 1&&(admini.getAdmininame()!=""&&admini.getAdminipassword()!="")) {
            session.setAttribute("loginUser","admini");
         //   session.setMaxInactiveInterval(5);
            String token= JwtUtil.createJwt(admini.getAdmininame());
            admini.setToken(token);
            return new R(true,admini, "登录成功");
        }
        else if ((admini.getAdmininame()==""||admini.getAdminipassword()=="")&&flag!=1){
            return new R(false, "请输入完整的信息");
        }
        else if(admini.getAdmininame()!=""&&admini.getAdminipassword()!=""&&flag!=1) return new R(false, "您的账号或密码有误，请重新输入");
        else return new R(false,"系统错误");
    }

//    @GetMapping("/checkToken")
//    public R checkToken(HttpServletRequest request){
//        String token=request.getHeader("token");
//        return new R(JwtUtil.checkToken(token));
//    }
    @GetMapping
    public R checkToken(@RequestBody Admini admini){
        String token=admini.getToken();
        return new R(JwtUtil.checkToken(token));
    }

}


