package com.coderwing.cloud.zipkin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderwing.cloud.zipkin.service.ZipkinTraceOneService;

@RestController
@RequestMapping("/trace")
@Slf4j
public class ZipkinTraceController {

    @Autowired
    private ZipkinTraceOneService zipkinTraceTwoService ;

    @GetMapping("/two")
    public String two() {
        log.info("Request Zipkin trace two API");
        return "I'm zipkin trace tow!";
    }


    @GetMapping("/two-one")
    public String reqTraceOne() {
        String res = zipkinTraceTwoService.traceOne();
        return res ;
    }



}
