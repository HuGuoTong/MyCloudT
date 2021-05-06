package com.hgt.order.controller;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    @Autowired
    private DiscoveryClient client;

    private final String url = "http://HGT-PAY/";


    @GetMapping("/submitOrder")
    public String submitOrder(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url+"aliPay/test1",String.class);
        return forEntity.getBody().toString();
    }

    @GetMapping("/testEurekaClient")
    public String testEurekaClient(){
        List<ServiceInstance> instanceInfos = client.getInstances("HGT-PAY");
        if(instanceInfos!=null&&instanceInfos.size()>0){

            return instanceInfos.get(0).getServiceId()+instanceInfos.get(0).getUri().toString();
        }else {
            return "未发现HGT-PAY服务";
        }
    }
}
