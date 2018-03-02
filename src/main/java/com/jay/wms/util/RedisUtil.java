package com.jay.wms.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisUtil {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;


    public void set(String key,String value,int expireTime){
        Jedis jedis = new Jedis(host,port);
        jedis.expire(key,expireTime);
        jedis.set(key,value);
    }

    public String get(String key){
        Jedis jedis = new Jedis(host,port);
        return jedis.get(key);
    }
}
