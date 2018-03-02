package com.jay.wms.controller;

import com.jay.wms.annotation.Auth;
import com.jay.wms.entity.User;
import com.jay.wms.service.UserSerivce;
import com.jay.wms.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/add")
    public User add(@RequestBody User user) {
        userSerivce.add(user);
        return user;
    }

    @Auth( check = false)
    @RequestMapping("/login")
    public Map login(@RequestBody User user) throws Exception {
        if (user.getAccount() == null ||
                "".equals(user.getAccount()) ||
                user.getPassword() == null ||
                "".equals(user.getPassword())) {
            throw new Exception();
        }
        List<User> list = userSerivce.query(user);
        if (list == null || list.size() != 1) {
            throw new Exception();
        }
        user = list.get(0);
        String uuid = UUID.randomUUID().toString();
        redisUtil.set(user.getId(), uuid, 60 * 30);
        Map map = new HashMap();
        map.put("user",user);
        map.put("token",uuid);
        return map;
    }
}
