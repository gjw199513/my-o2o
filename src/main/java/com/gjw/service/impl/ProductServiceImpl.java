package com.gjw.service.impl;

import com.gjw.dao.ProductDao;
import com.gjw.dao.ProductImgDao;
import com.gjw.dto.ImageHolder;
import com.gjw.dto.ProductCategoryExecution;
import com.gjw.dto.ProductExecution;
import com.gjw.entity.Product;
import com.gjw.entity.ProductImg;
import com.gjw.enums.ProductStateEnum;
import com.gjw.exceptions.ProductOperationException;
import com.gjw.service.ProductService;
import com.gjw.util.ImageUtil;
import com.gjw.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    /**
     * 添加商品信息以及图片处理
     * 1.处理缩略图，获取缩略图相对路径并赋值给product
     * 2.往tb_product写入商品信息，获取productId
     * 3.结合productId批量处理商品详情图
     * 4.将商品详情图列表批量插入tb_product_img中
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    @Transactional
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException {
        // 空值判断
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            // 给商品设置上默认属性
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            // 默认为上架的状态
            product.setEnableStatus(1);
            // 若商品缩略图不为空则添加
            if (thumbnail != null) {
                addThumbnail(product, thumbnail);
            }
            try {
                // 创建商品信息
                int effectedNum = productDao.insertProduct(product);
                if (effectedNum <= 0) {
                    throw new ProductOperationException("创建商品失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品失败：" + e.toString());
            }
            // 若商品详情图不为空则添加
            if (productImgList != null && productImgList.size() > 0) {
                addProductImgList(product, productImgList);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        } else {
            // 传参为空则返回空值错误信息
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 添加缩略图
     *
     * @param product
     * @param thumbnail
     */
    private void addThumbnail(Product product, ImageHolder thumbnail) {
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        product.setImgAddr(thumbnailAddr);
    }

    /**
     * 批量添加图片
     * @param product
     * @param productImgHolderList
     */
    private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
//        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
//        List<String> imgAddrList = ImageUtil.generateNormalImgs(productImgList, dest);
//        if (imgAddrList != null && imgAddrList.size() > 0) {
//            List<ProductImg> productImgList = new ArrayList<ProductImg>();
//            for (String imgAddr : imgAddrList) {
//                ProductImg productImg = new ProductImg();
//                productImg.setImgAddr(imgAddr);
//                productImg.setProductId(product.getProductId());
//                productImg.setCreateTime(new Date());
//                productImgList.add(productImg);
//            }
//            try {
//                int effectedNum = productImgDao.batchInsertProductImg(productImgList);
//                if (effectedNum <= 0) {
//                    throw new RuntimeException("创建商品详情图片失败");
//                }
//            } catch (Exception e) {
//                throw new RuntimeException("创建商品详情图片失败:" + e.toString());
//            }
//        }

        // 获取图片存储路径，这里直接存放到对应店铺的文件夹底下
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        // 遍历图片一次去处理，并添加进productImg实体类中
        for(ImageHolder productImgHolder: productImgHolderList){
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder,dest);
            ProductImg productImg = new ProductImg();
            productImg.setImgAddr(imgAddr);
            productImg.setImgAddr(imgAddr);
            productImg.setProductId(product.getProductId());
            productImg.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        // 如果确实是有图片需要添加，就进行批量添加操作
        if(productImgList.size()>0){
            try {
                int effectNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectNum <= 0){
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            }catch (Exception e){
                throw new ProductOperationException("创建商品详情图片失败："+e.toString());
            }
        }
    }
}
