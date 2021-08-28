package com.pyr.controller;

import com.pyr.pojo.OrderInfo;
import com.pyr.pojo.User;
import com.pyr.service.MiaoshaService;
import com.pyr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    MiaoshaService miaoshaService;

    @Autowired
    UserService userService;

    @RequestMapping("/do_miaosha")
    public String domiaosha(@RequestParam("goodsId") long goodsId, Model model) {
        User user = userService.getById(1);
        OrderInfo orderinfo = miaoshaService.miaohsa(goodsId, user);
        model.addAttribute("orderInfo", orderinfo);
        return "order_detail";
    }

}
