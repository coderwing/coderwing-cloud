package com.coderwing.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 开启Eureka注册
@EnableEurekaClient
// 启动服务发现
@EnableDiscoveryClient
// 启动配置文件刷新能力
@RefreshScope
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudConfigClientApplication.class, args ) ;
    }

}
