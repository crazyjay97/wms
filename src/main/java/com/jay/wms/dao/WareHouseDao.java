package com.jay.wms.dao;

import com.jay.wms.entity.WareHouse;

import java.util.List;

public interface WareHouseDao {
    List<WareHouse> queryByDeptId(String id);

    Integer add(WareHouse wareHouse);

    void update(WareHouse wareHouse);

    void del(String id);
}
