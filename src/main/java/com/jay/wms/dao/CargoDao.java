package com.jay.wms.dao;

import com.jay.wms.entity.Cargo;

import java.util.List;

public interface CargoDao {
    List<CargoDao> queryByDeptId(String id);

    Integer add(Cargo cargo);

    void update(Cargo cargo);
}
