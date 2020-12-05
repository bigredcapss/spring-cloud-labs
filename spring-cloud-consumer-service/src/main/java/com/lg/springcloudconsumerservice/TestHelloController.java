package com.lg.springcloudconsumerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
@RestController
public class TestHelloController {

    @Autowired
    IHelloControllerFeign helloControllerFeign;

    @GetMapping("/hello")
    public String test(){
        return helloControllerFeign.sayHello();
    }
}
