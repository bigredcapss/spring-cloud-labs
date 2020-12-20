package com.lg.goodsprovider;

import com.lg.goods.IGoodsQueryService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BigRedCaps
 * @date 2020/12/19 15:47
 */
@RestController
public class GoodsQueryServiceImpl implements IGoodsQueryService
{
    @Override
    public String queryGoods ()
    {
        return "Goods Info";
    }
}
