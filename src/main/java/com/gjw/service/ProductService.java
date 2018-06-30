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

    /**
     * 通过商品id查询唯一的商品信息
     *
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有:商品名（模糊），商品状态，店铺id，商品类别
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
