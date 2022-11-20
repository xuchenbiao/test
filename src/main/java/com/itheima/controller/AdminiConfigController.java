package com.itheima.controller;

import com.itheima.domain.Admini;
import com.itheima.service.AdminiService;
import com.itheima.util.JwtUtil;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/adminis")
public class AdminiConfigController {
   @Autowired
   private AdminiService adminiService;
//    @DeleteMapping
//    public R deleteSession(HttpSession session){
//       // session.setAttribute("loginUser",null);
//        session.removeAttribute("loginUser");
//        System.out.println("66");
//        return  new R(true);
//    }
    @PostMapping
    public R Login1(@RequestBody Admini admini, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
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
            session.setMaxInactiveInterval(30);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60*30);//设置cookie的生命周期为30min
            response.addCookie(cookie);
            String token= JwtUtil.createJwt(admini.getAdmininame());
            admini.setToken(token);
            return new R(true,admini, "登录成功");
      }
       else if(admini.getAdmininame().equals("tuichu")){
           session.setAttribute("loginUser",null);
           return new R(true, "成功退出");
        }
        else if ((admini.getAdmininame()==""||admini.getAdminipassword()=="")&&flag!=1){
            return new R(false, "请输入完整的信息");
        }
        else if(admini.getAdmininame()!=""&&admini.getAdminipassword()!=""&&flag!=1) return new R(false, "您的账号或密码有误，请重新输入");
        else return new R(false,"系统错误");
    }

    @GetMapping
    public R checkToken(HttpServletRequest request){
        String token=request.getHeader("token");
        return new R(JwtUtil.checkToken(token));
    }




}


