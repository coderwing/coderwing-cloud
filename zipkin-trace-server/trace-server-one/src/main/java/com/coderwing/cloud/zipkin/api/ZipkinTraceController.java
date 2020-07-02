package com.coderwing.cloud.zipkin.api;

import com.coderwing.cloud.zipkin.service.ZipkinTraceTwoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trace")
@Slf4j
public class ZipkinTraceController {

    @Autowired
    private ZipkinTraceTwoService zipkinTraceTwoService ;

    @GetMapping("/one")
    public String one() {
        log.info("Request Zipkin trace one API");
        return "I'm zipkin trace one!";
    }


    @GetMapping("/one-two")
    public String reqTraceTwo() {
        String res = zipkinTraceTwoService.traceTwo();
        return res ;
    }



}
