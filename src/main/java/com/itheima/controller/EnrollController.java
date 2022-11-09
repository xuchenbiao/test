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
       if (k==1&&(user.getUsername()!=""&&user.getPassword()!="")){
           return  new R(false,"注册失败!用户信息已存在");
       }
       else  if((user.getUsername()==""||user.getPassword()=="")&&k!=1){
           return  new R(false,"请输入完整信息");
       }
       else{
          if(user.getUsername().length()<8||user.getUsername().length()>16||
            user.getPassword().length()<8||user.getPassword().length()>16)
          {
              return new R(false,"账号或密码格式错误(均不能低于8位或者高于16位)");
          }

          else
              return  new R(enrollService.insert(user.getUsername(), user.getPassword()),"注册成功");
       }

    }
}
