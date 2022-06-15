package com.health.Service.impl;

import com.health.Service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 往redis放值
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 取值
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {

       return  redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(String key, long expire) {

        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 删除key
     * @param key
     */
    @Override
    public void remove(String key) {

        redisTemplate.delete(key);
    }


    /**
     * 自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    @Override
    public Long increment(String key, long delta) {


        return redisTemplate.opsForValue().increment(key,delta);
    }
}
