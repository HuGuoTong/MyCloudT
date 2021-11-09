package com.hgt.order.config;

import com.hgt.order.netty.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @Author: HGT
 * @Description: 容器启动后，启动netty服务
 * @Date: 2021/8/18 17:03
 * @Version: 1.0 implements CommandLineRunner
 */
@Component
public class NettyInitListen  {

    @Value("${netty.port}")
    Integer nettyPort;
    @Value("${netty.ip}")
    String nettyIp;

    @Autowired
    private NettyServer nettyServer;

//    @Override
    public void run(String... args) throws Exception {
        try {
            InetSocketAddress address = new InetSocketAddress(nettyIp,nettyPort);
            nettyServer.start(address);
        } catch (Exception e) {
            System.out.println("NettyServerError:" + e.getMessage());
        }
    }
}
