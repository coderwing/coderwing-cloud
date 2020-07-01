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

    @Value("${foo}")
    private String zuulId ;

    @RequestMapping("/name")
    public String name() {
        log.info( "从cloud-config-server获取到配置属性 name:【{}】", zuulId );
        return zuulId ;
    }


}
