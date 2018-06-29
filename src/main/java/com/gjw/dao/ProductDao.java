package com.gjw.dao;

import com.gjw.entity.Product;

/**
 * Created by Administrator on 2018/6/29.
 */
public interface ProductDao {

    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(Product product);
}
