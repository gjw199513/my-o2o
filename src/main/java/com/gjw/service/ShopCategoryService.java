package com.gjw.service;

import com.gjw.entity.ShopCategory;

import java.util.List;

/**
 * Created by gjw19 on 2018/6/24.
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
