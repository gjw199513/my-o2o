package com.gjw.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.jaxen.BaseXPath;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by gjw19 on 2018/6/23.
 */
public class ImageUtil {
    // 通过线程获取绝对路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    // 格式日期
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    // 随机数对象
    private static final Random r = new Random();

    /**
     * 生成水印图片
     *
     * @param thumbnailInputStream
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.geteImgBasePath() + relativeAddr);
        try {
            // 解决路径带中文的问题
            String newBasePath = URLDecoder.decode(basePath,"UTF-8");

            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(newBasePath + "watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }


    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    public static String getRandomFileName() {
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return (nowTimeStr + rannum);
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及的目录，即/home/work/xiangze/xxx.jpg
     * 那么home work xiangze 这三个文件夹都得自动创建
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.geteImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        // 通过线程获取绝对路径
        String seperator = System.getProperty("file.separator");
        // 解决路径带中文的问题
        String newBasePath = URLDecoder.decode(basePath,"UTF-8");
        System.out.println(newBasePath);
        System.out.println(basePath+"watermark.jpg");
//        System.out.println((basePath+"/watermark.jpg").replace("/",seperator));
        Thumbnails.of(new File("E:\\慕课\\java-慕课\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\2017061320315746624.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(newBasePath+"watermark.jpg")), 0.25f).outputQuality(0.8f)
                .toFile("E:\\慕课\\java-慕课\\SSM到Spring Boot-从零开发校园商铺平台 加\\images\\item\\headtitle\\111.jpg");
    }
}