package com.itheima.controller;

import com.itheima.dao.EnrollDao;
import com.itheima.service.EnrollService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enrolls")
public class EnrollController {
    @Autowired
   private EnrollDao enrollDao;
    @Autowired
    private EnrollService enrollService;
    @PostMapping("/{username}/{password}")
    public R Enroll(@PathVariable String username, @PathVariable String password){
          int k=0;
        List<String> list=enrollDao.getAllName();
       for (int i=0;i<list.size();i++){
          if (list.get(i).equals(username)){k=1;break;}
          else k=0;
       }
       if (k==1){
           return  new R(false,"注册失败!用户信息已存在");
       }
       else{
          if(username.length()<8||username.length()>16){
              return new R(false,"账号格式不能低于8位或者高于16位");
          }
          else if(password.length()<6||password.length()>18){
              return new R(false,"密码格式不能低于6位或高于18位");
          }
          else
              return  new R(enrollService.insert(username,password),"注册成功");
       }

    }
}
