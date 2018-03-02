package com.jay.wms.dao;

import com.jay.wms.entity.Department;

import java.util.List;

public interface DepartmentDao {

    Integer add(Department department);

    void update(Department department);

    List<Department> query(Department department);
}
