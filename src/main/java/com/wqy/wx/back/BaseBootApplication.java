package com.wqy.wx.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BaseBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseBootApplication.class, args);
        System.out.println("==========启动成功 ！=======");
    }

}
