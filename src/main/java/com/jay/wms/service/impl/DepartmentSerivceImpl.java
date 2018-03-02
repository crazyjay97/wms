package com.jay.wms.service.impl;

import com.jay.wms.dao.DepartmentDao;
import com.jay.wms.entity.Department;
import com.jay.wms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentSerivceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.add(department);
        Map map = new HashMap();
        map.put("id",department.getId());
        map.put("userId",department.getCreateBy());
        map.put("isAdmin",1);
        departmentDao.addUserRel(map);
    }

    @Override
    public List<Department> query(Department department) {
        return departmentDao.query(department);
    }

    @Override
    public Department queryByUserId(String id) {
        return departmentDao.queryByUserId(id);
    }
}
