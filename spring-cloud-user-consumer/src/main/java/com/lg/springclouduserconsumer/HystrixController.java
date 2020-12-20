package com.lg.springclouduserconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(commandProperties ={
       @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            /*
             * 第一个点：
             * 熔断机制：默认10s内，20个请求的的失败率达到50%，就会熔断服务5s，之后会尝试接收请求，然后尝试逐渐恢复服务；
             * 第二个点：
             * 依赖隔离：Hystrix提供了两种隔离策略，线程池隔离和信号量隔离
             * 以下@HystrixProperty配置的意思是：10s内，5个请求的失败率达到50%，就会熔断服务10s,然后尝试逐渐恢复服务
             *
             *
             * */
       /*@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
       @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
       @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
       @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE")*/
    })
    @GetMapping("/hystrix/user")
    public String queryUser(/*@PathVariable("num")int num*/){
        /*if(num%2==0){
            return "正常的访问结果";
        }*/
        //超过1s没有返回，我就认为你是失败的。
        return restTemplate.getForObject("http://localhost:8080/user",String.class);
    }

    public String defaultFallback(){
        return "系统繁忙，请稍候再试";
    }

}
