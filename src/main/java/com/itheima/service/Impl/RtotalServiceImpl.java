package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.RtotalDao;
import com.itheima.dao.TotalDao;
import com.itheima.domain.Rtotal;
import com.itheima.domain.Total;
import com.itheima.service.RtotalService;
import org.springframework.stereotype.Service;

@Service
public class RtotalServiceImpl extends ServiceImpl<RtotalDao, Rtotal> implements RtotalService {
}
