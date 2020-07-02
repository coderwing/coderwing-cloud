package com.feign.service.fallback;

import com.feign.service.UserService;
import org.springframework.stereotype.Component;

/**
 * UserService接口的断路器
 * 实现所代理的service接口，重写对应的接口方法
 *
 */
@Component
public class UserServiceFallback implements UserService {

    @Override
    public String addUser(String name) {
        return "adduser: "+name+" error!!!";
    }

}
