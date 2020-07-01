package com.robbon.contorller;

import com.robbon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/add")
    public Object addUser( @RequestParam("name") String name ) {
        Object res = userService.addUser(name);
        log.info("调用 USER-API:add res:{}", res);
        return res ;
    }


}
