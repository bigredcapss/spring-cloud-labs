package com.lg.springcloudconsumerservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
// feign ->Ribbon
@FeignClient(name = "spring-cloud-provider-serivce",configuration =FeginLogConfig.class )
public interface IHelloControllerFeign {

    //URLConnection| okHttp
    @GetMapping("/hello")
    String sayHello ();
}
