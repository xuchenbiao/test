package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    public List<String> getName();
    public List<String> getPassword();
    public List<String> getUserNames(String username);
    public List<User> getName(String username);
    public IPage<User> getPage(int current, int size);
}
