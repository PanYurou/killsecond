package com.pyr.mapper;

import com.pyr.pojo.MiaoshaOrder;
import com.pyr.pojo.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {

    @Insert("insert into order_info(goods_id,goods_name,goods_price,goods_count,user_id) values(#{goodsId},#{goodsName},#{goodsPrice},#{goodsCount},#{userId})")
    public long insertOrderInfo(OrderInfo orderInfo);

    @Insert("insert into miaosha_order(goods_id,order_id,user_id) values(#{goodsId},#{orderId},#{userId})")
    void insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
