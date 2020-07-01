package com.feign.controller;

import com.feign.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/add")
    public Object addUser( @RequestParam("name") String name ) {
        Object res = userService.addUser(name);
        log.info("feign 调用USER-API:add res:{}", res);
        return res ;
    }


}
