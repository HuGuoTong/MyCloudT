package com.hgt.common.test;

import lombok.Data;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/4/8 11:03
 * @Version: 1.0
 */
@Data
public class User {

    private String name;

    private String flag;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
