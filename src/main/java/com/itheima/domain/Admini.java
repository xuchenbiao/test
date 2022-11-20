package com.itheima.domain;

import lombok.Data;

@Data
public class Admini {
    private Integer id;
    private String admininame;
    private String adminipassword;
    private String token;
}
