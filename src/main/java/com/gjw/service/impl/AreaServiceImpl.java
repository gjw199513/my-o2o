package com.gjw.service.impl;

import com.gjw.dao.AreaDao;
import com.gjw.entity.Area;
import com.gjw.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gjw19 on 2018/6/23.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

}
