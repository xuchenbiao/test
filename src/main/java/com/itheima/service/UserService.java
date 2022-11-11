package com.itheima.service;

import java.util.List;

public interface UserService {
    public List<String> getName();
    public List<String> getPassword();
    public List<String> getUserNames(String username);
}
