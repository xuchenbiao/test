package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Rtotal;
import com.itheima.domain.Total;
import com.itheima.domain.User;

import java.util.List;

public interface RtotalService extends IService<Rtotal> {
    public IPage<Rtotal> getPage(int current, int size);

    public List<Rtotal> selectByName(String name);
    public boolean deleteAll();
}
