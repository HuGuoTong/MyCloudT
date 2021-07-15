package com.hgt.pay8085;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 15:59
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Pay8085Application {
    public static void main(String[] args) {
        SpringApplication.run(Pay8085Application.class,args);
    }
}
