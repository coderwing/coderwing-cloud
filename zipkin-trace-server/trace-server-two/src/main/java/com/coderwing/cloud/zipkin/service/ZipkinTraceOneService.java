package com.coderwing.cloud.zipkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipkinTraceOneService {

    @Autowired
    private RestTemplate restTemplate ;

    public String traceOne() {
        String forObject = restTemplate.getForObject("http://localhost:9008/trace/one", String.class);
        return forObject ;
    }

}
