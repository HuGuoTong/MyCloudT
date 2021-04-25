package com.hgt.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 21:25
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
