package com.gjw.service;

/**
 * Created by gjw19 on 2018/7/4.
 */
public interface CacheService {

    /**
     * 依据key前缀删除匹配该模式下的所有key-value 如传入shopCategory,则shopcategory_allfirstlevel等
     * 以shopCategory打头的key_value都会被清空
     *
     * @param keyPrefix
     */
    void removeFromCache(String keyPrefix);
}
