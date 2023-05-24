package com.gdlgxy.lgcommunity.service;

import com.gdlgxy.lgcommunity.dao.UserMapper;
import com.gdlgxy.lgcommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

}
