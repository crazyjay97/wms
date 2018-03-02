package com.jay.wms.dao;

import com.jay.wms.entity.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> query(User user);

}
