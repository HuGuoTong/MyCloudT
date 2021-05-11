package com.hgt.order.controller;

import com.hgt.order.feign.AliPayControllerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 15:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AliPayControllerFeign aliPayControllerFeign;

    @GetMapping("/submitOrder")
    public String submitOrder(){
        String forEntity = aliPayControllerFeign.createPayOrder();
        return forEntity;
    }

    @GetMapping("/submitOrder3s")
    public String submitOrder3s(){
        String forEntity = aliPayControllerFeign.testAnd3S();
        return forEntity;
    }

}
