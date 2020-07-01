package com.coderwing.goods.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @GetMapping("/add")
    public Object add(@RequestParam("name") String name) {
        log.info("添加商品name:{}", name);
        return "OK" ;
    }

    @GetMapping("/{name}")
    public Object info(@PathVariable("name") String name) {
        log.info("商品name:{}", name);
        return name ;
    }

}
