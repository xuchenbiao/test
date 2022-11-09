package com.itheima.controller;

import com.itheima.dao.EnrollDao;
import com.itheima.domain.User;
import com.itheima.service.EnrollService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrolls")
public class EnrollController {
    @Autowired
   private EnrollDao enrollDao;
    @Autowired
    private EnrollService enrollService;
    @PostMapping
    public R Enroll(@RequestBody User user){
          int k=0;
        List<String> list=enrollDao.getAllName();
       for (int i=0;i<list.size();i++){
          if (list.get(i).equals(user.getUsername())){k=1;break;}
          else k=0;
       }
       if (k==1){
           return  new R(false,"注册失败!用户信息已存在");
       }
       else{
          if(user.getUsername().length()<8||user.getUsername().length()>16){
              return new R(false,"账号格式不能低于8位或者高于16位");
          }
          else if(user.getPassword().length()<6||user.getPassword().length()>18){
              return new R(false,"密码格式不能低于6位或高于18位");
          }
          else
              return  new R(enrollService.insert(user.getUsername(), user.getPassword()),"注册成功");
       }

    }
}
