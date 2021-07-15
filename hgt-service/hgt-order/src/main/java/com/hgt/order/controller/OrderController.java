package com.hgt.order.controller;

import com.hgt.order.feign.AliPayControllerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
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
@RefreshScope
public class OrderController {

    @Autowired
    private AliPayControllerFeign aliPayControllerFeign;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${nimabi}")
    private String testConfig;

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

    @GetMapping("/tstReset")
    public String tstReset(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://hgt-pay/aliPay/test1",String.class);;
        return response.getBody();
    }

    @GetMapping("/tstConfig")
    public String tstConfig(){
        return "???"+testConfig;
    }

}
