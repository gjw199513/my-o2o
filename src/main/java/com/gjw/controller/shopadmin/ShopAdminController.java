package com.gjw.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gjw19 on 2018/6/24.
 */
@Controller
@RequestMapping(value = "shopadmin", method = RequestMethod.GET)
public class ShopAdminController {
    @RequestMapping(value = "/shopopeeration")
    public String shopOperation(){
        return "shop/shopoperation";
    }
}