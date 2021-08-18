package com.pyr.controller;

import com.pyr.pojo.GoodsVo;
import com.pyr.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/list")
    public String all_goods(Model model) {
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String show(Model model, @PathVariable("goodsId") long goodsId) {

        GoodsVo goods = goodsService.findGoodById(goodsId);
        model.addAttribute("goods", goods);
        return "goods_detail";
    }
}
