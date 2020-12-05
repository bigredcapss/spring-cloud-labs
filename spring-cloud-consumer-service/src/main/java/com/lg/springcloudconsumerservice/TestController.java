package com.lg.springcloudconsumerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

//    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(){
        //Ribbon ：
        // 1. 调用Eureka DiscoveryClient   去获得spring-cloud-provider-consumer -> url地址列表
        // 2. 负载均衡的算法
        //http://localhost:8080/hello (httpclient)
        ServiceInstance serviceInstance=loadBalancerClient.choose("spring-cloud-provider-serivce");
        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/hello");
        return restTemplate.getForObject(url,String.class);
    }
}
