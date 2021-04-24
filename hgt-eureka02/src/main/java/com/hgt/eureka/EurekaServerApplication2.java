package com.hgt.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/14 15:00
 * @Version: 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class,args);
    }
}
