package com.jay.wms.service.impl;

import com.jay.wms.dao.DepartmentDao;
import com.jay.wms.entity.Department;
import com.jay.wms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentSerivceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }

    @Override
    public List<Department> query(Department department) {
        return departmentDao.query(department);
    }
}
