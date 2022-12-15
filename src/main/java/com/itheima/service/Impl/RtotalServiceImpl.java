package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.RtotalDao;
import com.itheima.dao.TotalDao;
import com.itheima.domain.Rtotal;
import com.itheima.domain.Total;
import com.itheima.service.RtotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class RtotalServiceImpl extends ServiceImpl<RtotalDao, Rtotal> implements RtotalService {
    @Autowired
    private RtotalDao rtotalDao;

    @Override
    public IPage<Rtotal> getPage(int current, int size) {
        IPage page=new Page(current,size);
       rtotalDao.selectPage(page,null);
        return page;
    }

    @Override
    public List<Rtotal> selectByName(String name) {
        return rtotalDao.selectByName(name);
    }

    @Override
    public boolean deleteAll() {
        return rtotalDao.deleteAllRtotal();
    }


}
