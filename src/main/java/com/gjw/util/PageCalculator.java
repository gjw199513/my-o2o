package com.gjw.util;

/**
 * Created by Administrator on 2018/6/26.
 */
public class PageCalculator {
    /**
     * 分页转换
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
