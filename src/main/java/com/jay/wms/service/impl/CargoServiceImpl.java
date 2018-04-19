package com.jay.wms.service.impl;

import com.jay.wms.dao.CargoDao;
import com.jay.wms.entity.Cargo;
import com.jay.wms.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoDao dao;

    @Override
    public List<CargoDao> queryByDeptId(String id) {
        return dao.queryByDeptId(id);
    }

    @Override
    public Integer add(Cargo cargo) {
        return dao.add(cargo);
    }

    @Override
    public void update(Cargo cargo) {
        dao.update(cargo);
    }
}
