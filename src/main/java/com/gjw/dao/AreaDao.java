package com.gjw.dao;

import com.gjw.entity.Area;

import java.util.List;

/**
 * Created by gjw19 on 2018/6/23.
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
