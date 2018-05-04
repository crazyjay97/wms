package com.jay.wms.dao;

import com.jay.wms.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    void add(User user);

    List<User> query(User user);

    List<User> queryByDeptId(String id);

    void delUserFromDept(String id);

    List<User> findUserByAccount(String account);

    /**
     * #{userId},#{deptId},#{isAdmin}
     *
     * @param rel
     */
    void addToDept(Map rel);

    /**
     * #{account}
     * #{deptId}
     * @param cd
     * @return
     */
    List<User> findUserInDept(Map cd);

}
