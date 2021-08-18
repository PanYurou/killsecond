package com.pyr.mapper;

import com.pyr.pojo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select g.*, m.miaosha_price, m.amount,m.start_date from goods g left join miaosha_goods m  on g.id = m.goods_id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*, m.miaosha_price, m.amount,m.start_date from goods g left join miaosha_goods m  on g.id = m.goods_id where g.id = #{goodsId}")
    GoodsVo findGoodById(long goodsId);
}
