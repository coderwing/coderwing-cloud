package com.coderwing.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
// 启动Eureka服务注册
@EnableEurekaClient
// 启动Eureka服务发现
@EnableDiscoveryClient
// 启动断路器支持
@EnableHystrix
// 内部使用了 EnableCircuitBreakerImportSelector 加载相关的断路器配置类；熔断超时机制
@EnableCircuitBreaker
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudGatewayApplication.class, args ) ;
    }

}
