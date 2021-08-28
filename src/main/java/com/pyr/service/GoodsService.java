package com.pyr.service;

import com.pyr.mapper.GoodsMapper;
import com.pyr.pojo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<GoodsVo> listGoodsVo() {
        return goodsMapper.listGoodsVo();
    }

    public GoodsVo findGoodById(long goodsId) {
        return goodsMapper.findGoodById(goodsId);
    }

    public void reduceAamount(long goodsId) {
        goodsMapper.reduceAamount(goodsId);
    }
}
