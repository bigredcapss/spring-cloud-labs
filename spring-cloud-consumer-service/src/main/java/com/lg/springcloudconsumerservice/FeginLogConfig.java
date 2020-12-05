package com.lg.springcloudconsumerservice;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
@Configuration
public class FeginLogConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
