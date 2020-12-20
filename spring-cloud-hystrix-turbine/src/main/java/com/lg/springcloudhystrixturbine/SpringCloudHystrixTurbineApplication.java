package com.lg.springcloudhystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class SpringCloudHystrixTurbineApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(SpringCloudHystrixTurbineApplication.class, args);
    }

}
