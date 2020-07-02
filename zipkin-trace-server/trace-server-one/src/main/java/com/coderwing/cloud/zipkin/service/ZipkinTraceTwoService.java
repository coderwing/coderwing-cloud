package com.coderwing.cloud.zipkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipkinTraceTwoService {

    @Autowired
    private RestTemplate restTemplate ;

    public String traceTwo() {
        String forObject = restTemplate.getForObject("http://localhost:9009/trace/two", String.class);
        return forObject ;
    }

}
