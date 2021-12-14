package com.example.controller;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;




    @RequestMapping("/hello")
    public String hello(){

        User u=new User();
        u.setId(1);
        u.setName("jackwang");
        u.setPassword("123456");
        u.setRealName("jack");
        redisTemplate.opsForValue().set("hh",u);

        User user=redisTemplate.opsForValue().get("hh");
        System.out.println(user);
        return "Hello Spring!!6666!77773333!!!";
    }

    @RequestMapping("/getUser")
    public Object getUser(){
        User user = redisTemplate.opsForValue().get("hh");
        return user;
    }

}
