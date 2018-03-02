package com.jay.wms.service;


import com.jay.wms.entity.User;

import java.util.List;

public interface UserSerivce {
    void add(User user);

    List<User> query(User user);

    List<User> queryByDeptId(String deptId);
}
