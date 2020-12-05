package com.lg.springcloudproviderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(User user){
        System.out.println("接收到请求");
        return "Hello WE";
    }
}
