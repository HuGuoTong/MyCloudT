package com.hgt.common.test;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.util.Assert;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/8 11:07
 * @Version: 1.0
 */
public class Test {

    public static List<User> getUsers(){
        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setName("R");
        u1.setFlag("11");
        list.add(u1);

        User u2 = new User();
        u2.setName("P");
        u2.setFlag("22");
        list.add(u2);
        return list;
    }

    public static void main(String[] args) throws Exception{
        List<User> list = getUsers();
//        list.stream().forEach(e->{
//            e.setName("bb");
//        });
//        for(User u:list){
//            u.setName("cc");
//        }
//        list = list.stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList());
//
//        System.out.println(list);

//        Date date = new Date();
//        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 0 1 26 * ?");
//
//        Date time1 = cronSequenceGenerator.next(date);//下次执行时间
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
//        System.out.println(sdf.format(time1));
//        Date time2 = cronSequenceGenerator.next(time1);
//        Date time3 = cronSequenceGenerator.next(time2);
//        long l = time1.getTime() -(time3.getTime() -time2.getTime());
//        Date date1 = new Date(l);//上一次任务执行时间
//        sdf.format(null);
        MyWebSocketClient client = new MyWebSocketClient(new URI("ws://localhost:8081/websocketT/first"));
        client.connect();
        while(!client.getReadyState().equals(WebSocketClient.READYSTATE.OPEN)){
            System.out.println("连接中....");
            Thread.sleep(1000);
        }
        client.send("我先发条消息");
    }
}
