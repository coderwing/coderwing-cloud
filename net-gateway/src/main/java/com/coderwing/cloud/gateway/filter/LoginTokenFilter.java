package com.coderwing.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoginTokenFilter implements GatewayFilter, Ordered {

    private static final String LOGIN_TOKEN_KEY = "USER_LOGIN_TOKEN" ;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpResponse response = exchange.getResponse();

        String loginToken = headers.getFirst(LOGIN_TOKEN_KEY) ;

        // TODO: 2020/7/3  token校验
        if (StringUtils.isEmpty(loginToken) ) {
            log.warn("login token is null");
            response.setStatusCode(HttpStatus.UNAUTHORIZED) ;
            return response.setComplete() ;
        }

        return chain.filter( exchange );
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
