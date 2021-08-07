package com.pyr.service;

import com.pyr.mapper.UserMapper;
import com.pyr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getById(int id) {
        return userMapper.getUserById(id);
    }
}
