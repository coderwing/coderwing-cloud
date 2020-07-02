package com.coderwing.cloud.gateway.routeapi;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutController {

    @Bean
    public RouteLocator cwRoutes(RouteLocatorBuilder builder) {
        // 链式调用
        return builder.routes()
                .route( p -> p
                        .path("/uadd")
                        .filters( f -> f
                                    .addRequestHeader("h1","v1") )
                                .uri("http://localhost:9004/user/add"))
                                .build() ;
    }

}
