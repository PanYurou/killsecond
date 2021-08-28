package com.pyr.service;

import com.pyr.pojo.OrderInfo;
import com.pyr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiaoshaService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderInfoService orderInfoService;

    public OrderInfo miaohsa(long goodsId, User user) {
//    1.查看是否有余量
//    2.查看是否已经秒杀过了该商品
//    3.减库存
        goodsService.reduceAamount(goodsId);
//    4.创建订单
        return orderInfoService.createOrder(user, goodsId);
    }
}
