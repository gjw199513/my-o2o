package com.gjw.dao;

import com.gjw.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

	/**
	 * 通过productId查询唯一的商品信息
	 *
	 * @param productId
	 * @return
	 */
	Product queryProductByProductId(long productId);

	/**
	 * 更新商品信息
	 *
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

	/**
	 * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺Id,商品类别
	 *
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(
			@Param("productCondition") Product productCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	/**
	 * 查询对应的商品总数
	 *
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);

	/**
	 * 删除商品类别之前，将商品类别ID置为空
	 *
	 * @param productCategoryId
	 * @return
	 */
	int updateProductCategoryToNull(long productCategoryId);
}
