package com.robbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate ;


    @HystrixCommand( fallbackMethod = "addUserErre")
    public Object addUser( String name ) {
        String forObject = restTemplate.getForObject("http://CLOUD-USER-API/user/add?name=" + name, String.class);
        return forObject ;
    }

    // 对应addUser服务的fallback
    // 当USER-API服务不可用时，调用addUser服务接口则调用该方法
    public String addUserErre( String name ) {
        return "addUser:" + name + "error!" ;
    }


}
