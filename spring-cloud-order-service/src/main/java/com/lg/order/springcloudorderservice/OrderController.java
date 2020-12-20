package com.lg.order.springcloudorderservice;

import com.lg.client.IUserServiceFeignClient;
import com.lg.goods.client.IGoodsQueryServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 聚合用户服务和商品服务
 * @author BigRedCaps
 * @date 2020/12/19 16:25
 */
@RestController
public class OrderController
{
    @Autowired
    IGoodsQueryServiceFeignClient goodServiceFeignClient;
    @Autowired
    IUserServiceFeignClient userServiceFeignClient;

    @PostMapping("/order")
    public String createOrder(){
        String goodsInfo = goodServiceFeignClient.queryGoods();
        String userInfo = userServiceFeignClient.queryUser();
        return goodsInfo+userInfo;
    }

}
