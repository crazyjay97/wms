package com.jay.wms.service.impl;

import com.jay.wms.dao.CargoDao;
import com.jay.wms.entity.Cargo;
import com.jay.wms.entity.CargoWhRel;
import com.jay.wms.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoDao dao;

    @Override
    public List<Cargo> queryByDeptId(String id) {
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

    @Override
    public void del(String id) {
        dao.del(id);
    }

    @Override
    public CargoWhRel queryCargoNumById(String id) {
        return dao.queryCargoNumById(id);
    }

    @Override
    public Integer joinToWh(CargoWhRel rel) {
        return dao.joinToWh(rel);
    }

    @Override
    public List<CargoWhRel> queryByWhId(String id) {
        return dao.queryByWhId(id);
    }

    @Override
    public void updateRel(CargoWhRel rel) {
        dao.updateRel(rel);
    }

    @Override
    public void delRel(String id) {
        dao.delRel(id);
    }
}
