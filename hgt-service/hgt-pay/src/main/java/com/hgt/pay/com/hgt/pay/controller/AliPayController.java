package com.hgt.pay.com.hgt.pay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 15:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("aliPay")
public class AliPayController {

    @Value("${server.port}")
    private String servePort;

    @GetMapping("/test1")
    public String createPayOrder(){
        return "调用的pay:"+servePort;
    }
}
