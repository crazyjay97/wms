package com.jay.wms.service.impl;

import com.jay.wms.dao.WareHouseDao;
import com.jay.wms.entity.WareHouse;
import com.jay.wms.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    private WareHouseDao dao;

    @Override
    public List<WareHouse> queryByDeptId(String id) {
        return dao.queryByDeptId(id);
    }

    @Override
    public Integer add(WareHouse wareHouse) {
        return dao.add(wareHouse);
    }

    @Override
    public void update(WareHouse wareHouse) {
        dao.update(wareHouse);
    }

    @Override
    public void del(Integer[] id) {
        dao.del(id);
    }
}
