package com.wanghuan.blogserver.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisUtil {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper omJson;

    public boolean deleteKeysByPerFix(String perFix){
        Set<String> keys = redisTemplate.keys(perFix);
        String[] mykeys = new String[keys.size()];
        keys.toArray(mykeys);
        this.del(mykeys);
        return true;
    }

    public boolean expire(String key, long time){
        try {
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
                return true;
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return false;
    }

    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return false;
    }

    public void del(String... key){
        if(key != null && key.length > 0){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    public Object get(String key){
        return key == null ? null:redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return false;
    }

    public boolean set(String key,Object value,long time){
        try {
            if (time > 0)
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            else
                set(key,value);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return false;
    }

    public long incr(String key,long delta){
        if (delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,delta);
    }

    public long decr(String key,long delta){
        if (delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key,delta);
    }
}
