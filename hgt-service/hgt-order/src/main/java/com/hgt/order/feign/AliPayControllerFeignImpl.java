package com.hgt.order.feign;

import org.springframework.stereotype.Component;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/5/8 10:39
 * @Version: 1.0
 */
@Component
public class AliPayControllerFeignImpl implements AliPayControllerFeign {
    @Override
    public String createPayOrder() {
        return null;
    }

    @Override
    public String testAnd3S() {
        return null;
    }
}
