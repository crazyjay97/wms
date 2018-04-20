package com.jay.wms.service;

import com.jay.wms.entity.Cargo;
import com.jay.wms.entity.CargoWhRel;

import java.util.List;

public interface CargoService {
    List<Cargo> queryByDeptId(String id);

    Integer add(Cargo cargo);

    void update(Cargo cargo);

    void del(String id);

    CargoWhRel queryCargoNumById(String id);

    Integer joinToWh(CargoWhRel rel);

    List<CargoWhRel> queryByWhId(String id);

    void updateRel(CargoWhRel rel);

    void delRel(String id);
}
