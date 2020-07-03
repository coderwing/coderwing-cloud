package com.coderwing.cloud.gateway.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class UserFallbackController {

    @RequestMapping("/user/fallback")
    public String userFallback() {
        log.info("User server fall!");
        return "User server Fall!" ;
    }

}
