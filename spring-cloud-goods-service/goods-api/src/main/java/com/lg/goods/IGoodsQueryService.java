package com.lg.goods;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BigRedCaps
 * @date 2020/12/19 15:36
 */
public interface IGoodsQueryService
{
    @GetMapping("/goods")
    String queryGoods();
}
