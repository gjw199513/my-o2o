package com.gjw.dao;

import com.gjw.BaseTest;
import com.gjw.entity.Area;
import com.gjw.entity.PersonInfo;
import com.gjw.entity.Shop;
import com.gjw.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by gjw19 on 2018/6/23.
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryByShopId(){
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId:" + shop.getArea().getAreaId());
        System.out.println("areaName:"+shop.getArea().getAreaName());

    }
    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1l);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1l);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int i = shopDao.insertShop(shop);
        assertEquals(1,i);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1l);
        shop.setShopDesc("testdesc");
        shop.setShopAddr("testaddr");
        shop.setPhone("testphone");
        shop.setLastEditTime(new Date());
        int i = shopDao.updateShop(shop);
        assertEquals(1,i);
    }
}
