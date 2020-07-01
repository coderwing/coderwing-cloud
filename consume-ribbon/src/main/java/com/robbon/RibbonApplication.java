package com.robbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
// 启动Eureka client注册
@EnableEurekaClient
// 启动服务发现
@EnableDiscoveryClient
// 启动断路器支持
@EnableHystrix
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run( RibbonApplication.class, args ) ;
    }

}
