package com.gjw.service.impl;

import com.gjw.dao.ProductCategoryDao;
import com.gjw.dto.ProductCategoryExecution;
import com.gjw.entity.ProductCategory;
import com.gjw.enums.ProductCategoryStateEnum;
import com.gjw.exceptions.ProductCategoryOperationException;
import com.gjw.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return
     */
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectedNum <= 0) {
                    throw new ProductCategoryOperationException("店铺类别创建失败");
                } else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }

            } catch (Exception e) {
                throw new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
            }
        } else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
        // todo 将此商品类别下的商品的类别id置为空
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }


}
