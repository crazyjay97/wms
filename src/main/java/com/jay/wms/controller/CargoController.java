package com.jay.wms.controller;

import com.jay.wms.entity.Cargo;
import com.jay.wms.entity.CargoWhRel;
import com.jay.wms.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoService service;

    @RequestMapping("/add")
    public Integer add(@RequestBody Cargo cargo) {
        return service.add(cargo);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Cargo cargo) {
        service.update(cargo);
    }

    @RequestMapping("/queryByDeptId")
    public List<Cargo> queryByDeptId(HttpServletRequest request) {
        return service.queryByDeptId(request.getParameter("id"));
    }

    @RequestMapping("del")
    public String del(HttpServletRequest request) {
        String id = request.getParameter("id");
        CargoWhRel rel = service.queryCargoNumById(id);
        if (null == rel || 0 == rel.getNum()) {
            service.del(id);
            return "1";
        }
        return "0";
    }

    @RequestMapping("joinToWh")
    public Integer joinToWh(@RequestBody CargoWhRel rel){
        return service.joinToWh(rel);
    }

    @RequestMapping("queryByWhId")
    public List<CargoWhRel> queryByWhId(HttpServletRequest request){
        return service.queryByWhId(request.getParameter("id"));
    }

    @RequestMapping("updateRel")
    public void updateRel(@RequestBody CargoWhRel rel){
        if(rel.getNum() == 0){
            service.delRel(rel.getId().toString());
        }else {
            service.updateRel(rel);
        }

    }
}