package com.demo.service.impl;

import com.demo.annotation.LocalCache;
import com.demo.annotation.RedisCache;
import com.demo.entity.Senior;
import com.demo.mapper.SeniorMapper;
import com.demo.service.SeniorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 14:12
 **/
@Service
public class SeniorServiceImpl implements SeniorService {

    @Autowired
    SeniorMapper seniorMapper;

    @Override
    @LocalCache(value = "senior",unit = TimeUnit.DAYS,timeout = 1)
    public List<Senior> findSenior() {
        return seniorMapper.findIdCard();

    }
}
