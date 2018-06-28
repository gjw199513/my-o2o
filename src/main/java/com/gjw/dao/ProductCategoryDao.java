package com.gjw.dao;

import com.gjw.entity.ProductCategory;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */
public interface ProductCategoryDao {

    /**
     * 通过shopid 查询店铺商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);
}
