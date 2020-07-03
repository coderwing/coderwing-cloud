package com.coderwing.cloud.gateway.config;

import com.coderwing.cloud.gateway.filter.LoginTokenFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( predicateSpec -> predicateSpec
                    .path("/userapi/**")
                    .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(1).filter( new LoginTokenFilter()))
                    .uri("lb://BIZ-USER-API")
                    .id("BIZ-USER-API-1"))

                .route( predicateSpec -> predicateSpec
                        .path("/userapi2/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(2).filter( new LoginTokenFilter()))
                        .uri("lb://BIZ-USER-API")
                        .id("BIZ-USER-API-2"))
                .build()
                ;
    }

}
