package com.hgt.common.test.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: HGT
 * @Description: socket服务端
 * @Date: 2021/8/18 14:57
 * @Version: 1.0
 */
public class SocektServerT {

    public static void main(String[] args) {
        try {
            //建立服务端，监听8080端口
            ServerSocket server = new ServerSocket(8080);

            while(true){
                Socket socket = null;
                try{
                    socket = server.accept();
                    System.out.println("有客户端成功连接"+socket.getInetAddress()+":"+socket.getPort());

                    //创建一个新的线程
                    ServerThread serverThread=new ServerThread(socket);
                    //启动线程
                    serverThread.start();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
//                    if(socket!=null){
//                        socket.close();
//                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
