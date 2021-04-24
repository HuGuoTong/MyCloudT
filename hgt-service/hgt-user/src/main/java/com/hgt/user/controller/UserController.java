package com.hgt.user.controller;

import com.hgt.bean.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/5 10:25
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userInfoById")
    public String getUserInfoById(){
        User u = new User();
        u.setName("Harry Potter fonix");
        return u.getName();
    }
}
