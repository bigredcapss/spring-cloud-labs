package com.lg.springclouduserconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker //启动断路器
@EnableFeignClients("com.lg.client")
@ComponentScan(basePackages ={"com.lg.client","com.lg.springclouduserconsumer"})
@SpringBootApplication
public class SpringCloudUserConsumerApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(SpringCloudUserConsumerApplication.class, args);
    }

}
