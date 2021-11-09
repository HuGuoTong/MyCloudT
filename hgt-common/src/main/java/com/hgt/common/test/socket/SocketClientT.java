package com.hgt.common.test.socket;

import java.io.*;
import java.net.Socket;

/**
 * @Author: HGT
 * @Description: socket客户端
 * @Date: 2021/8/18 14:57
 * @Version: 1.0
 */
public class SocketClientT {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1",8080);

        //2.获取输出流，向服务器端发送信息
        OutputStream os= client.getOutputStream();//字节输出流
        PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
        pw.write("Hello");
        pw.flush();
        client.shutdownOutput();//关闭输出流

        //3.获取输入流，并读取服务器端的响应信息
        InputStream is= client.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String info=null;
        while((info=br.readLine())!=null){
            System.out.println("我是客户端，服务器说："+info);
        }

        //4.关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        client.close();
    }
}
