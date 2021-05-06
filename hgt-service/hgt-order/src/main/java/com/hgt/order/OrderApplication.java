package com.hgt.order;

import com.hgt.order.com.hgt.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 15:35
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "HGT-PAY",configuration = MySelfRule.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
