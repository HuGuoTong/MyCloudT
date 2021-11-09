package com.hgt.order.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author: HGT
 * @Description: 代码生成
 * @Date: 2021/11/4 7:49
 * @Version: 1.0
 */
public class MyGeneraterUtil {

    private static String url = "jdbc:mysql://127.0.0.1:3306/willlink_market_dev?useUnicode=true&characterEncoding=utf-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai";

    public static void main(String[] args) {
        FastAutoGenerator.create(url,"root","hgt3306")
                .globalConfig(builder -> {
                    builder.author("HuXiaoWu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .commentDate("yyyy-MM-dd")
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.hgt.bean.entity") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "D:\\Develope\\MyCloudT\\hgt-service\\hgt-bean\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_simple") // 设置需要生成的表名
                            .addTablePrefix(); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
