package com.gjw.util;

/**
 * Created by gjw19 on 2018/6/23.
 */
public class PathUtil {

    // 获取文件的分隔符
    private static String seperator = System.getProperty("file.separator");

    /**
     * 获取存储基础路径
     * @return
     */
    public static String geteImgBasePath(){
        // 获取系统名称
        String os = System.getProperty("os.name");

        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/java程序/my-o2o";
        }else {
            basePath = "/home/199513/image/";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    // 获取图片路径
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",seperator);
    }
}
