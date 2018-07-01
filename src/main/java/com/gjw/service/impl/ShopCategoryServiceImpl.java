package com.gjw.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gjw.cache.JedisUtil;
import com.gjw.dao.ShopCategoryDao;
import com.gjw.entity.ShopCategory;
import com.gjw.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjw19 on 2018/6/24.
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private JedisUtil.Strings jedisStrings;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    private static String SCLISTKEY = "shopcategorylist";

    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException {
        String key = SCLISTKEY;
        List<ShopCategory> shopCategoryList = null;
        ObjectMapper mapper = new ObjectMapper();
        if (!jedisKeys.exists(key)) {
//			ShopCategory shopCategoryCondition = new ShopCategory();
//			shopCategoryCondition.setParentId(parentId);
//			shopCategoryList = shopCategoryDao
//					.queryShopCategory(shopCategoryCondition);
//			String jsonString = mapper.writeValueAsString(shopCategoryList);
//			jedisStrings.set(key, jsonString);
        } else {
            String jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory()
                    .constructParametricType(ArrayList.class,
                            ShopCategory.class);
            shopCategoryList = mapper.readValue(jsonString, javaType);
        }
        return shopCategoryList;
    }
}
