package com.health.Service;

public interface RedisService {


    /**
     * redis操作Service,
     * 对象和数组都以json形式进行存储
     * Created by macro on 2018/8/7.
     */
        /**
         * 存储数据
         */
        void set(String key, Object value);

        /**
         * 获取数据
         */
        Object get(String key);

        /**
         * 设置超期时间
         */
        boolean expire(String key, long expire);

        /**
         * 删除数据
         */
        void remove(String key);

        /**
         * 自增操作
         * @param delta 自增步长
         */
        Long increment(String key, long delta);



}
