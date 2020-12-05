package com.lg.springclouduserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:27
 */
@RestController
public class TestController {


    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/product/{id}")
    public String queryProductInfo(@PathVariable("id")int id){
        // 1 根据名字去获得服务提供者的地址信息
        // 2 负载均衡
        return restTemplate.getForObject("http://spring-cloud-product-service/product/"+id,String .class);
    }
}
