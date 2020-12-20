package com.lg.order.springcloudorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = {"com.lg.client","com.lg.goods.client"})
@SpringBootApplication
public class SpringCloudOrderServiceApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(SpringCloudOrderServiceApplication.class, args);
    }

}
