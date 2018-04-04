package com.tetel.restful.controller;

import com.tetel.restful.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = UserController.USER_URL)
public class UserController {
//    主地址
    protected  static  final String USER_URL="/user";
    private static Map<String,User> addUser = new HashMap<>();


    /**
     *新增用户
     * @param user
     * @return
     */
    @PostMapping()
    public User postUser(@RequestBody User user){
//        也可以通过@RequestParam从页面中传递参数
       addUser.put(user.getUname(),user);
        return user;
    }

    /**
     * 通过用户名获取用户列表
     * @param uname
     * @return
     */
    @GetMapping("/{uname}")
    public User getUser(@PathVariable String uname){
        return  addUser.get(uname);
    }
}
