package com.jay.wms.dao;

import com.jay.wms.entity.Department;
import com.jay.wms.entity.User;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    Integer add(Department department);

    void update(Department department);

    List<Department> query(Department department);

    Department queryByUserId(String id);

    void addUserRel(Map map);
}
