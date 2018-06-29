package com.gjw.service;

import com.gjw.BaseTest;
import com.gjw.dto.ImageHolder;
import com.gjw.dto.ProductExecution;
import com.gjw.entity.Area;
import com.gjw.entity.Product;
import com.gjw.entity.ProductCategory;
import com.gjw.entity.Shop;
import com.gjw.enums.ProductStateEnum;
import com.gjw.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2018/6/29.
 */
public class ProductServiceTest extends BaseTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() throws ShopOperationException, FileNotFoundException {
        // 创建shopId为1切productCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1l);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1l);
        product.setShop(shop);
        product.setProductCategory(pc);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        // 创建缩略图文件流
        File thumbnailFile = new File("D:\\java程序\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\2017061320400198256.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(is,thumbnailFile.getName());
        // 创建两个商品详情图文件流并将它们添加到详情图列表中
        File productImg1 = new File("D:\\java程序\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\2017061320371786788.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("D:\\java程序\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\2017061320315746624.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList=  new ArrayList<ImageHolder>();
        productImgList.add(new ImageHolder(is1,productImg1.getName()));
        productImgList.add(new ImageHolder(is2,productImg2.getName()));
        // 添加商品并验证
        ProductExecution pe = productService.addProduct(product,thumbnail,productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
    }
}
