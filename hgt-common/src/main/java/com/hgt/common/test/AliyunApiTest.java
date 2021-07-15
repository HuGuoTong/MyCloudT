package com.hgt.common.test;


import com.alibaba.fastjson.JSONObject;
import com.hgt.common.utils.HttpUtils;
import com.hgt.common.utils.MyBase64Utils;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/6/30 14:30
 * @Version: 1.0
 */
public class AliyunApiTest {
    public static void main(String[] args) {
        pdf识别();
    }

    private static void pdf识别(){
        String host = "https://generalpdf.market.alicloudapi.com";
        String path = "/ocrservice/pdf";
        String method = "POST";
        String appcode = "e0ef147000fb4a3f9c3e6c8628e17c93";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
//        String bodys = "{//文件数据：base64编码，要求base64编码后大小不超过100M，页数不超过20页，和url参数只能同时存在一个\"fileBase64\":\"\",//文件url地址：完整URL，URL长度不超过1024字节，URL对应的文件base64编码后大小不超过100M，页数不超过20页，和img参数只能同时存在一个\"url\":\"\",//是否需要识别结果中每一行的置信度，默认不需要。true：需要false：不需要\"prob\":false,//是否需要单字识别功能，默认不需要。true：需要false：不需要\"charInfo\":false,//是否需要自动旋转功能，默认不需要。true：需要false：不需要\"rotate\":false,//是否需要表格识别功能，默认不需要。true：需要false：不需要\"table\":false,//转文件类型，word\"fileType\":\"word\"}";
        JSONObject object = new JSONObject();
        String base64 = MyBase64Utils.pdf2Base64("D:\\\\template\\\\COMPANY_JOIN_IN.pdf");
        object.put("fileBase64",base64);
        object.put("prob",false);
        object.put("charInfo",false);
        object.put("rotate",false);
        object.put("table",false);
        object.put("fileType","word");

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, object.toJSONString());
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
