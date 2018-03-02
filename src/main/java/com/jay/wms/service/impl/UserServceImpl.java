package com.jay.wms.service.impl;

import com.jay.wms.dao.UserDao;
import com.jay.wms.entity.User;
import com.jay.wms.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServceImpl implements UserSerivce {
    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        user.setId(uuid);
        userDao.add(user);
    }

    @Override
    public List<User> query(User user) {
        return userDao.query(user);
    }
}
