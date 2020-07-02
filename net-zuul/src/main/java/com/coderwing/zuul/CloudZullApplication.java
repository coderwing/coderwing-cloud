package com.coderwing.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
// 启动zuul支持
@EnableZuulProxy
// Eureka client
@EnableEurekaClient
// 支持服务发现
@EnableDiscoveryClient
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CloudZullApplication {
    public static void main(String[] args) {
        SpringApplication.run( CloudZullApplication.class, args ) ;
    }
}
