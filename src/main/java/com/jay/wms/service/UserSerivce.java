package com.jay.wms.service;


import com.jay.wms.entity.User;

import java.util.List;
import java.util.Map;

public interface UserSerivce {
    void add(User user);

    List<User> query(User user);

    List<User> queryByDeptId(String deptId);

    void delUserFromDept(String id);

    void joinToDept(Map c) throws Exception;
}
