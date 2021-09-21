package com.pyr.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisSevice {

    @Autowired
    JedisPool jedisPool;

    public <T>  boolean set(String key, T values) {
        String value = JSON.toJSONString(values);
        ;
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        return true;
    }

    public <T> T get(String key, Class clazz) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get(key);
        T t = (T) JSON.toJavaObject(JSON.parseObject(str), clazz);
        return t;
    }
}
