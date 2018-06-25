package com.gjw.dao;

import com.gjw.entity.Shop;

/**
 * Created by gjw19 on 2018/6/23.
 */
public interface ShopDao {

    /**
     * 通过shopid 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
