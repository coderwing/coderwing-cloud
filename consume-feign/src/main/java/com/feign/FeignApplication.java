package com.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign 集成了Ribbon，具有负载的功能
 * Feign 支持Hystrix熔断器功能，不用像Ribbon那样去设置，Feign自带断路器，但是默认是关闭的
 *
 */
@SpringBootApplication
// Eureka client注册
@EnableEurekaClient
// 支持服务发现
@EnableDiscoveryClient
// Feign 调用支持
@EnableFeignClients
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run( FeignApplication.class,args ) ;
    }

}
