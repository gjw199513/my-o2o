package com.gjw.dao;

import com.gjw.entity.ProductImg;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
public interface ProductImgDao {

    /**
     * 批量批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);
}
