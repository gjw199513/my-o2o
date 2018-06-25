package com.gjw.service;

import com.gjw.BaseTest;
import com.gjw.dto.ShopExecution;
import com.gjw.entity.Area;
import com.gjw.entity.PersonInfo;
import com.gjw.entity.Shop;
import com.gjw.entity.ShopCategory;
import com.gjw.enums.ShopStateEnum;
import com.gjw.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by gjw19 on 2018/6/24.
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("测试w");
        shop.setShopDesc("tests1211");
        shop.setShopAddr("test1211");
        shop.setPhone("test12s");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("E:\\慕课\\java-慕课\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\2017061320315746624.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop,is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }

    @Test
    public void testModifyShop() throws ShopOperationException,FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(1l);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("D:\\java程序\\my-o2o\\src\\main\\resources\\watermark.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution shopExecution= shopService.modifyShop(shop, is, "watermark.jpg");
        System.out.println("新的图片地址"+shopExecution.getShop().getShopImg());
    }
}
