package com.hgt.common.test;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.report.MessageDetailResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/5/5 7:34
 * @Version: 1.0
 */
public class JPushTest {

    private static String appkey = "695c2da52fa673d1d574340d";
    private static String masterSecret = "695c2da52fa673d1d574340d";

    public static void main(String[] args) {
        JPushClient jPushClient = new JPushClient(masterSecret, appkey);
        String msgIds = "962059bc4515479980b2ccdea2ce6125";
        try {
            MessageDetailResult result = jPushClient.getMessagesDetail(msgIds);
            System.out.println("msgIds: {}, MessageDetail: {}"+ result.received_list);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }
    }
}
