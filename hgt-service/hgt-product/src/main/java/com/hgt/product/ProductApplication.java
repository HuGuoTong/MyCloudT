package com.hgt.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 15:31
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }

}
