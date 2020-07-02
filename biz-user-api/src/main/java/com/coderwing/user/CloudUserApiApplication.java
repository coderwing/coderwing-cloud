package com.coderwing.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 注册Eureka client
@EnableEurekaClient
public class CloudUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudUserApiApplication.class, args ) ;
    }

}
