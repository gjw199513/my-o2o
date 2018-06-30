package com.gjw.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gjw19 on 2018/6/24.
 */
@Controller
@RequestMapping(value = "shopadmin", method = RequestMethod.GET)
public class ShopAdminController {

    // 店铺操作
    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    // 店铺展示
    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    // 店铺管理
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    // 商品类别管理
    @RequestMapping(value = "/productcategorymanagement", method = RequestMethod.GET)
    private String productCategoryManage() {
        return "shop/productcategorymanagement";
    }

    // 商品操作
    @RequestMapping(value = "/productoperation")
    private String productOperation() {
        return "shop/productoperation";
    }

    // 商品管理
    @RequestMapping(value = "/productmanagement")
    private String productManagement() {
        return "shop/productmanagement";
    }

}
