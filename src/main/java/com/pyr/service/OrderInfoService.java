package com.pyr.service;

import com.pyr.mapper.GoodsMapper;
import com.pyr.mapper.OrderInfoMapper;
import com.pyr.pojo.Goods;
import com.pyr.pojo.MiaoshaOrder;
import com.pyr.pojo.OrderInfo;
import com.pyr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderInfoService {
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    GoodsMapper goodsMapper;

    public OrderInfo createOrder(User user, long goodsId) {
        Goods goods = goodsMapper.findGoodById(goodsId);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setGoodsId(goodsId);
        orderInfo.setGoodsCount(1);
        orderInfo.setCreateDate(new Date());
        orderInfo.setGoodsPrice(goods.getPrice());
        orderInfo.setGoodsName(goods.getName());
        orderInfo.setUserId(user.getId());
        long orderId = orderInfoMapper.insertOrderInfo(orderInfo);
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setUserId(user.getId());
        orderInfoMapper.insertMiaoshaOrder(miaoshaOrder);
        return orderInfo;
    }
}
