package com.lg.goods.client;

import com.lg.goods.IGoodsQueryService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author BigRedCaps
 * @date 2020/12/19 15:50
 */
@FeignClient(name="spring-cloud-goods-service")
public interface IGoodsQueryServiceFeignClient extends IGoodsQueryService
{
}
