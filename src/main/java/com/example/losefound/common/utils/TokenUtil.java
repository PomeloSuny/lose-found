package com.example.losefound.common.utils;

import com.example.losefound.common.redis.RedisClient;
import com.example.losefound.entity.User;
import com.example.losefound.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 15:40
 */
@Component
public class TokenUtil {
    @Autowired
    RedisClient redisClient;
    @Autowired
    UserService userService;

    /**
     * 获取访问zx_wccy的token
     *
     * @return
     */
    public String getWccRequestToken(String username) {
        if (StringUtils.isBlank(username)) {
            username = (String) SecurityUtils.getSubject().getPrincipal();
        }
        String zxWccyToken = (String) SecurityUtils.getSubject().getSession().getAttribute("zxWccyRequestToken");
//        String zxWccyToken = redisClient.get(RedisKeyConstants.ZX_WCCY_REQUEST_TOEKN + username);
        if (StringUtils.isBlank(zxWccyToken)) {
            //重新登录获取token
            //todo didi 重新获取token
            String password = (String) SecurityUtils.getSubject().getSession().getAttribute("password");
            User user = userService.loginAndGetUserInfo(username, password);
//            saveUserInfo(userDetail);
//            redisClient.set(RedisKeyConstants.ZX_WCCY_REQUEST_TOEKN + username, zxWccyToken);
        }
//        System.err.println("token===================" + zxWccyToken);
        return zxWccyToken;
    }
}
