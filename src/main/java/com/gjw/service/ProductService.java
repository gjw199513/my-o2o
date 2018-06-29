package com.gjw.service;

import com.gjw.dto.ImageHolder;
import com.gjw.dto.ProductCategoryExecution;
import com.gjw.dto.ProductExecution;
import com.gjw.entity.Product;
import com.gjw.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
public interface ProductService {

    /**
     * 添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgList) throws ProductOperationException;
}
