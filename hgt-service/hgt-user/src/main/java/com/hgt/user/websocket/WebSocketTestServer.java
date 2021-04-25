package com.hgt.user.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/24 21:24
 * @Version: 1.0
 */
@ServerEndpoint("/websocketT/{pageCode}")
@Component
public class WebSocketTestServer {

    public static Map<String, List<Session>> electricSocketMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(@PathParam("pageCode") String pageCode,Session session){
        System.out.println("收到链接："+pageCode);
        List<Session> sessions = electricSocketMap.get(pageCode);
        if(sessions==null){
            List<Session> sessionList = new ArrayList<>();
            sessionList.add(session);
            electricSocketMap.put(pageCode,sessionList);
        }else{
            sessions.add(session);
        }
    }

    @OnClose
    public void OnClose(@PathParam("pageCode") String pageCode,Session session){
        if(electricSocketMap.containsKey(pageCode)){
            electricSocketMap.remove(pageCode);
        }
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("收到的消息"+message);
        try{
            session.getBasicRemote().sendText("消息已收到，over"+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
