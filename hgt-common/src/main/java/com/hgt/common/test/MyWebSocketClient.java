package com.hgt.common.test;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 21:40
 * @Version: 1.0
 */
public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("连接了");
    }

    @Override
    public void onMessage(String s) {
        System.out.println("收到的消息："+s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("关闭了");
    }

    @Override
    public void onError(Exception e) {

    }
}
