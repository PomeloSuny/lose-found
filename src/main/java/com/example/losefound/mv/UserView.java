package com.example.losefound.mv;

import com.example.losefound.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 14:26
 */
@Controller
public class UserView {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String index(ModelMap map){
        return "redirect:/begin";
    }

    @RequestMapping("/begin")
    public String begin(ModelMap map){
        Integer userTitle = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userTitle");
        map.addAttribute("userTitle", userTitle);
        return "begin";
    }

    @RequestMapping("/login")
    public String login(ModelMap map){
        return "/login";
    }


}
