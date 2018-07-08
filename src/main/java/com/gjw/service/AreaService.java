package com.gjw.service;

import com.gjw.entity.Area;

import java.util.List;

/**
 * Created by gjw19 on 2018/6/23.
 */
public interface AreaService {
    public static final String AREALISTKEY = "arealist";

    /**
     * 获取区域列表，优先从缓存存取
     *
     * @return
     */
    List<Area> getAreaList();
}
