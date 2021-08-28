package com.pyr.mapper;

import com.pyr.pojo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select g.*, m.miaosha_price, m.amount,m.start_date from goods g left join miaosha_goods m  on g.id = m.goods_id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*, m.miaosha_price, m.amount,m.start_date from goods g left join miaosha_goods m  on g.id = m.goods_id where g.id = #{goodsId}")
    GoodsVo findGoodById(long goodsId);

    @Update("update miaosha_goods set amount = amount-1 where goods_id=#{goodsId} and amount > 0 ")
    void reduceAamount(long goodsId);
}
