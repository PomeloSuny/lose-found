package com.example.losefound.service.impl;

import com.example.losefound.common.ErrorInfo;
import com.example.losefound.common.ErrorInfoV2;
import com.example.losefound.common.enums.ApiCode;
import com.example.losefound.common.enums.ApiCodeV2;
import com.example.losefound.dao.UserMapper;
import com.example.losefound.entity.User;
import com.example.losefound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 11:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findByname(String username) {
        User userinfo = userMapper.findByName(username);
        return userinfo;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User loginAndGetUserInfo(String username, String password) {
        return null;
    }

    @Override
    public ErrorInfoV2 login(String username, String password) {
        User user = userMapper.findByName(username);
        if (!user.getPassword().equals(password)){
            return ErrorInfoV2.setApiCode(ApiCodeV2.USER_PAYPASSWORD_ERROR);
        }
        return ErrorInfoV2.getSuccess().setData(user);
    }
}
