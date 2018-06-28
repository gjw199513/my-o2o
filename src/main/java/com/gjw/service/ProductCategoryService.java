package com.gjw.service;

import com.gjw.dto.ProductCategoryExecution;
import com.gjw.entity.ProductCategory;
import com.gjw.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */
public interface ProductCategoryService {

    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
}
