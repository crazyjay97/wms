package com.jay.wms.service.impl;

import com.jay.wms.dao.UserDao;
import com.jay.wms.entity.User;
import com.jay.wms.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServceImpl implements UserSerivce {
    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        user.setId(uuid);
        userDao.add(user);
    }

    @Override
    public List<User> query(User user) {
        return userDao.query(user);
    }

    @Override
    public List<User> queryByDeptId(String deptId) {
        return userDao.queryByDeptId(deptId);
    }

    @Override
    public void delUserFromDept(String id) {
        userDao.delUserFromDept(id);
    }

    @Override
    public void joinToDept(Map c) throws Exception {
        List<User> users = userDao.findUserByAccount((String) c.get("account"));
        if (null == users || users.size() != 1) {
            throw new Exception("account not exists");
        }
        c.put("userId",users.get(0).getId());
        users = userDao.findUserInDept(c);
        if (null != users && users.size() > 0){
            throw new Exception("account already exists");
        }
        userDao.addToDept(c);
    }
}
