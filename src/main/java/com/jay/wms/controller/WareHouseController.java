package com.jay.wms.controller;

import com.jay.wms.entity.WareHouse;
import com.jay.wms.service.WareHouseService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wh")
public class WareHouseController {
    @Autowired
    private WareHouseService service;

    @RequestMapping("add")
    public Integer add(@RequestBody WareHouse wareHouse) {
        return service.add(wareHouse);
    }

    @RequestMapping("update")
    public void update(@RequestBody WareHouse wareHouse) {
        service.update(wareHouse);
    }

    @RequestMapping("del")
    public void del(HttpServletRequest request) {
        service.del(request.getParameter("id"));
    }

    @RequestMapping("queryByDeptId")
    public List<WareHouse> queryByDeptId(HttpServletRequest request) {
        return service.queryByDeptId(request.getParameter("id"));
    }
}
