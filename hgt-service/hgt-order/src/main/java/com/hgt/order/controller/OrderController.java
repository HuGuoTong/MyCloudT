package com.hgt.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    private final String url = "http://HGT-PAY/";


    @GetMapping("/submitOrder")
    public String submitOrder(){
        return restTemplate.getForObject(url+"aliPay/test1",String.class);
    }
}
