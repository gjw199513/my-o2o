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

    /**
     * 批量插入商品分类数据
     *
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
