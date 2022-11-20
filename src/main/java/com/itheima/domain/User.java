package com.itheima.domain;

import lombok.Data;

@Data
public class User {
  private   String username;
   private String password;
   private Integer id;
   private String token;
}