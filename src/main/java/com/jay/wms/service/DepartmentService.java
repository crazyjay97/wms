package com.jay.wms.service;

import com.jay.wms.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);

    List<Department> query(Department department);
}
