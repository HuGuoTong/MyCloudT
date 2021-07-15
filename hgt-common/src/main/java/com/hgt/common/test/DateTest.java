package com.hgt.common.test;

import java.time.LocalDate;

/**
 * @Author: HGT
 * @Description: ${description}
 * @Date: 2021/6/29 10:43
 * @Version: 1.0
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        date = date.plusDays(100);
        System.out.println(date.getYear());
        System.out.println(date.getMonth().getValue());
    }
}
