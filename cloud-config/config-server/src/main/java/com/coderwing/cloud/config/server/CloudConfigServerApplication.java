package com.coderwing.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// 开启Config Server能力
@EnableConfigServer
// 非DB模式启动
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run( CloudConfigServerApplication.class, args ) ;
    }

}
