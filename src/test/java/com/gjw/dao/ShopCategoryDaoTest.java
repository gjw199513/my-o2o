package com.gjw.dao;

import com.gjw.BaseTest;
import com.gjw.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by gjw19 on 2018/6/24.
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
//        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
//        assertEquals(2,shopCategoryList.size());
//        ShopCategory testCategory = new ShopCategory();
//        ShopCategory parentCategory = new ShopCategory();
//        parentCategory.setShopCategoryId(1l);
//        testCategory.setParent(parentCategory);
//        shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
//        assertEquals(1,shopCategoryList.size());
//        System.out.println(shopCategoryList.get(0).getShopCategoryName());
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
        System.out.println(shopCategoryList.size());
    }

}
