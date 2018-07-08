package com.gjw.service.impl;

import com.gjw.cache.JedisUtil;
import com.gjw.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by gjw19 on 2018/7/4.
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private JedisUtil.Keys jedisKeys;

    /**
     * 依据key前缀删除匹配该模式下的所有key-value 如传入shopCategory,则shopcategory_allfirstlevel等
     * 以shopCategory打头的key_value都会被清空
     *
     * @param keyPrefix
     */
    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisKeys.keys(keyPrefix + '*');
        for (String key : keySet) {
            jedisKeys.del(key);
        }
    }
}
