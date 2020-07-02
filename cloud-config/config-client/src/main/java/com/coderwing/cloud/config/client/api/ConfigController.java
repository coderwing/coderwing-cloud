package com.coderwing.cloud.config.client.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从config-server服务获取配置信息
 *
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class ConfigController {

    @Value("${zuul.routes.api-a.path}")
    private String path ;

    @RequestMapping("/path")
    public String path() {
        log.info( "从cloud-config-server获取到配置属性 path:【{}】", path );
        return path ;
    }


}
