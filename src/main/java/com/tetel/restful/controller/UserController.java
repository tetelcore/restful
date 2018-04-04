package com.tetel.restful.controller;


import com.tetel.restful.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class UserController {

    @ApiOperation(value = "增加一个用户")
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return user;
    }

    @ApiOperation(value = "更改一个用户")
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return user;
    }

    @ApiOperation(value = "删除一个用户")
    @DeleteMapping("/user/{id}")
    public String delUser(@PathVariable ("id") Integer userId){
        return "ok";
    }
    @ApiOperation(value="获取一个用户")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer userId){
        User user=new User(1,"tetel","123456@outlook.com","123456");
        return user;
    }

}
