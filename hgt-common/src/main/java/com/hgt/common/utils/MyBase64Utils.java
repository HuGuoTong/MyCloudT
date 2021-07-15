package com.hgt.common.utils;

import org.bouncycastle.util.encoders.Base64;

import java.io.*;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/6/30 15:02
 * @Version: 1.0
 */
public class MyBase64Utils {

    public static String pdf2Base64(String filepath){
        FileInputStream fin=null;
        BufferedInputStream bin=null;
        ByteArrayOutputStream baos=null;
        BufferedOutputStream bout=null;

        try{
            File file=new File(filepath);
            if(!file.exists()){
                return "";
            }
            fin=new FileInputStream(file);
            bin=new BufferedInputStream(fin);
            baos=new ByteArrayOutputStream();
            bout=new BufferedOutputStream(baos);
            byte[] buffer=new byte[1024];
            int len=bin.read(buffer);
            while(len!=-1){
                bout.write(buffer,0,len);
                len=bin.read(buffer);
            }
            //读取完毕
            bout.flush();
            byte[] bytes=baos.toByteArray();
            String res= Base64.toBase64String(bytes);
            return res;
        }catch (Exception e){
            return "";
        }
    }
}
