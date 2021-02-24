package com.example.losefound.service;

import com.example.losefound.common.ErrorInfo;
import com.example.losefound.common.ErrorInfoV2;
import com.example.losefound.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 11:22
 */
@Service("userService")
public interface UserService {
    //查询
    public User findByname(String username);
    //增加
    public int insertUser(User user);

    User loginAndGetUserInfo(String username, String password);

    ErrorInfoV2 login(String username, String password);
}
