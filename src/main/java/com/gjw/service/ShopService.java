package com.gjw.service;

import com.gjw.dto.ShopExecution;
import com.gjw.entity.Shop;
import com.gjw.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * Created by gjw19 on 2018/6/24.
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
