package com.hgt.common.utils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: HGT
 * @Description: 原生请求
 * @Date: 2021/8/2 15:00
 * @Version: 1.0
 */
public class HttpUrlConnUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUrlConnUtils.class);

    /***
     * 使用GET方式 获取 接口数据
     * @param urlPath 请求地址
     * @return
     */
    public static String getResourceByHttpGet(String urlPath){
        StringBuffer returnResource = new StringBuffer();
        try {
            URL url = new URL(urlPath);
            URLConnection rulConnection = url.openConnection();
            // 此处的urlConnection对象实际上是根据URL的
            // 请求协议(此处是http)生成的URLConnection类
            // 的子类HttpURLConnection,故此处最好将其转化
            // 为HttpURLConnection类型的对象,以便用到
            // HttpURLConnection更多的API.如下:

            HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");

            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("GET");

            // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，
            httpUrlConnection.connect();

            // 调用HttpURLConnection连接对象的getInputStream()函数,
            // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            InputStream inStream = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里

            InputStreamReader inputStreamReader = new InputStreamReader(inStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;

            while ((str = bufferedReader.readLine()) != null){
                returnResource.append(str);
            }
            if(httpUrlConnection.getResponseCode() == httpUrlConnection.HTTP_OK){
//		                message.setCode(0);
//		                message.setContent(buffer.toString());
            }else{
                logger.debug("获取返回状态不对,返回状态为:" + httpUrlConnection.getResponseCode());
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inStream.close();
            inStream = null;
            httpUrlConnection.disconnect();
        } catch (Exception e) {
            logger.error("连接异常==="+e.getMessage());
//			e.printStackTrace();
        }


        return returnResource.toString();
    }



    /***
     * post方式  未实现
     * @param urlPath
     * @return
     */
    public static String getResourceByHttpPost(String urlPath){
        StringBuffer returnResource = new StringBuffer();
        try {
            URL url = new URL(urlPath);
            URLConnection rulConnection = url.openConnection();
            // 此处的urlConnection对象实际上是根据URL的
            // 请求协议(此处是http)生成的URLConnection类
            // 的子类HttpURLConnection,故此处最好将其转化
            // 为HttpURLConnection类型的对象,以便用到
            // HttpURLConnection更多的API.如下:

            HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;

            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);

            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);

            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);

            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");

            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");

            // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，
            httpUrlConnection.connect();

            // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，
            // 所以在开发中不调用上述的connect()也可以)。
            OutputStream outStrm = httpUrlConnection.getOutputStream();

            // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。
            ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);

            // 向对象输出流写出数据，这些数据将存到内存缓冲区中
            objOutputStrm.writeObject("");

            // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
            objOutputStrm.flush();

            // 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中,
            // 在调用下边的getInputStream()函数时才把准备好的http请求正式发送到服务器
            objOutputStrm.close();

            // 调用HttpURLConnection连接对象的getInputStream()函数,
            // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            InputStream inStream = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里

            InputStreamReader inputStreamReader = new InputStreamReader(inStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;

            while ((str = bufferedReader.readLine()) != null){
                returnResource.append(str);
            }
            if(httpUrlConnection.getResponseCode() == httpUrlConnection.HTTP_OK){
//                message.setCode(0);
//                message.setContent(buffer.toString());
            }else{
//                message.setCode(-1);
//                message.setContent("获取返回状态不对,返回状态为:" + conn.getResponseCode());
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inStream.close();
            inStream = null;
            httpUrlConnection.disconnect();



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return returnResource.toString();
    }
}
