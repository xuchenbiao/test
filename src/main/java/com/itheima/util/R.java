package com.itheima.util;

import lombok.Data;

@Data
public class R {
    boolean flag;
    Object data;

    public R() {
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag) {
        this.flag = flag;
    }
}
