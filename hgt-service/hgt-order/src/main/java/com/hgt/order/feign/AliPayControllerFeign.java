package com.hgt.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/5/7 11:23
 * @Version: 1.0
 */
@Component
@FeignClient(value = "HGT-PAY",fallback = AliPayControllerFeignImpl.class)
public interface AliPayControllerFeign {

    @GetMapping("/aliPay/test1")
    String createPayOrder();

    @GetMapping("/aliPay/testAnd3S")
    String testAnd3S();
}
