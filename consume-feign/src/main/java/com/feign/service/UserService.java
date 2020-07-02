package com.feign.service;

import com.feign.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign 接口定义调用
 */
// 指定调用的服务名称, 并指明断路器类
@FeignClient( value = "BIZ-USER-API" ,fallback = UserServiceFallback.class )
public interface UserService {

    // 这里使用 @RequestMapping 没问题，使用@GetMapping的话需要指明 consumes属性
    // @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    @GetMapping( value = "/user/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String addUser( @RequestParam("name") String name ) ;

}
