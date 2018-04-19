package com.jay.wms.service;

import com.jay.wms.dao.CargoDao;
import com.jay.wms.entity.Cargo;

import java.util.List;

public interface CargoService {
    List<CargoDao> queryByDeptId(String id);

    Integer add(Cargo cargo);

    void update(Cargo cargo);
}
