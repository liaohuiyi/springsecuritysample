/** 
 * <pre>项目名称:dxmq 
 * 文件名称:RedisUtils.java 
 * 包名:com.hyhy.dxmq.util 
 * 创建日期:2017年9月20日下午4:30:49 
 * Copyright (c) 2017, lizexing@163.com All Rights Reserved.</pre> 
 */  
package com.hyhy.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/** 
 * <pre>项目名称：dxmq    
 * 类名称：RedisUtils    
 * 类描述：    
 * 创建人：廖惠仪 liaohuiyi@huiyihuiying.com    
 * 创建时间：2017年9月20日 下午4:30:49    
 * 修改人：廖惠仪 liaohuiyi@huiyihuiying.com       
 * 修改时间：2017年9月20日 下午4:30:49    
 * 修改备注：       
 * @version </pre>    
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtils {
	private final static Logger logger  = LogManager.getLogger(RedisUtils.class);
	
	@SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     * 
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * 
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     * 
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * 
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     * 
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
        	logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
