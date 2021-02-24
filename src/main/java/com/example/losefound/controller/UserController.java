package com.example.losefound.controller;

import com.example.losefound.common.ErrorInfo;
import com.example.losefound.common.ErrorInfoV2;
import com.example.losefound.common.exception.ExceptionUtil;
import com.example.losefound.common.utils.TokenUtil;
import com.example.losefound.entity.User;
import com.example.losefound.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 11:27
 */
@Controller
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    TokenUtil tokenUtil;

    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public ErrorInfoV2 doLogin(HttpServletRequest servletRequest,
                             @RequestParam("username") String username,
                             @RequestParam("password")String password){
        ErrorInfoV2 errorInfo = ErrorInfoV2.getSuccess();
        errorInfo = userService.login(username,password);
        if (!ErrorInfoV2.isSuccessInfo(errorInfo)) {
            return errorInfo;
        }
        return errorInfo.setData("/index");
    }
//    public ErrorInfo doLogin(HttpServletRequest servletRequest,
//                             @RequestParam("username") String username,
//                             @RequestParam("password")String password){
//        Map<String, Object> map = new HashMap<>();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            //将存有用户名和密码的token存进subject中
//            subject.login(token);
//            ErrorInfo errorInfo = ErrorInfo.getSuccess();
//            String url = "/yundan";
//            SavedRequest savedRequest = WebUtils.getSavedRequest(servletRequest);
//            if (savedRequest != null) {
//                url = savedRequest.getRequestUrl();
//            }
//            errorInfo = userService.login(username,password);
//            if (!ErrorInfo.isSuccessInfo(errorInfo)) {
//                return errorInfo;
//            }
////            UserDetail userDetail = JSONObject.parseObject(errorInfo.getData().toString(), UserDetail.class);
////            System.err.println(errorInfo.getData().toString());
//
//            //保存session信息
////            tokenUtil.saveUserInfo(userDetail);
//            errorInfo.setData(url);
//            return errorInfo;
//        }  catch (IncorrectCredentialsException ice) {
//            System.out.println("用户名为：" + token.getPrincipal() + "的用户密码不正确");
//            return ErrorInfo.getSystemError().setMsg("用户名或密码错误");
//        } catch (LockedAccountException lae) {
//            System.out.println("用户名为：" + token.getPrincipal() + "的用户已被冻结");
//            return ErrorInfo.getSystemError().setMsg("该用户已被冻结");
//        } catch (AuthenticationException e) {
//            System.out.println(ExceptionUtil.exceptionMessageGet(e));
//            return ErrorInfo.getSystemError();
//        }
//    }

//    @RequestMapping(value = "/add",method = RequestMethod.GET)
//    @ResponseBody
//    public  String addUser() {
//        User user = new User();
//        user.setAccount("admin")
//                .setUsername("admin")
//                .setPassword("123123")
//                .setGender(0)
//                .setPhone("18099990000");
//        userService.insertUser(user);
//        return "插入成功";
//    }
//    @RequestMapping(value="/find",method=RequestMethod.GET)
//    @ResponseBody
//    public User queryUserByName(String username){
//        User userinfo = userService.findByname(username);
//        return userinfo;
//    }
}
