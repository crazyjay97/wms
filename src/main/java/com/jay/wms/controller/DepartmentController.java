package com.jay.wms.controller;

import com.jay.wms.entity.Department;
import com.jay.wms.entity.User;
import com.jay.wms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/add")
    public Department add(@RequestBody Department department) {
        departmentService.add(department);
        return department;
    }

    @RequestMapping("/query")
    public List<Department> query(@RequestBody Department department) {
        List<Department> list = departmentService.query(department);
        return list;
    }

    @RequestMapping("/queryByUserId")
    public Department queryByUserId(HttpServletRequest request) {
        String id = request.getParameter("id");
        return departmentService.queryByUserId(id);
    }


}
