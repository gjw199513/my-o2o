package com.gjw.dto;

import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/29.
 */

/**
 * 对图片类型进行封装，将图片名称和图片文件放入一个类中
 */
public class ImageHolder {
    private String imageName;
    private InputStream image;

    public ImageHolder(InputStream image,String imageName) {
        this.imageName = imageName;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
