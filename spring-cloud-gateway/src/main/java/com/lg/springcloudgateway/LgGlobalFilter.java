package com.lg.springcloudgateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 * @author BigRedCaps
 * @date 2020/12/12 9:25
 */
@Component
public class LgGlobalFilter implements GlobalFilter, Ordered {
    Logger logger= LoggerFactory.getLogger(LgGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("【PRE】");

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            logger.info("【POST】");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
