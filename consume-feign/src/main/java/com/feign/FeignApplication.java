package com.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
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
// 开启HystrixDashboard
@EnableHystrixDashboard
// 内部使用了 EnableCircuitBreakerImportSelector 加载相关的断路器配置类；熔断超时机制
@EnableCircuitBreaker
// 开启局和监控支持
@EnableTurbine
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run( FeignApplication.class,args ) ;
    }

}
