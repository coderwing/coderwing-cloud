package com.coderwing.user.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @GetMapping("/add")
    public Object add(@RequestParam("name") String name) {
        log.info("添加user name:{}", name);
        return "OK" ;
    }



}
