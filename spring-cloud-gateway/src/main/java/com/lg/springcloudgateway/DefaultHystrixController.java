package com.lg.springcloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BigRedCaps
 * @date 2020/12/19 13:45
 */
@RestController
public class DefaultHystrixController
{

    @GetMapping("/defaultFallback")
    public String defaultFallback(){
        return "网关触发降级";
    }
}
