package com.gjw.service;

import com.gjw.entity.ShopCategory;

import java.io.IOException;
import java.util.List;

/**
 * Created by gjw19 on 2018/6/24.
 */
public interface ShopCategoryService {
    /**
     * 根据查询条件获取ShopCategory列表
     *
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException;
}
